package com.ulovecode.modules.service.impl;

import com.ulovecode.common.utils.RedisUtils;
import com.ulovecode.modules.dao.ScoreMapper;
import com.ulovecode.modules.entity.domain.Score;
import com.ulovecode.modules.entity.domain.ScoreExample;
import com.ulovecode.modules.entity.domain.ScoreKey;
import com.ulovecode.modules.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@CacheConfig(cacheNames = "score")
public class ScoreServiceImpl implements ScoreService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    ScoreMapper scoreMapper;

    @Autowired
    RedisUtils redisUtils;


    @Override
//    @CachePut(key = "#score.get().sno")
    public void save(Optional<Score> score) {
        score.ifPresent(score1 -> {
            scoreMapper.insertSelective(score1);
        });

    }


    @Override
//    @CachePut(key = "#score.get().sno")
    public int update(Optional<Score> score) {
        score.ifPresent(score1 -> scoreMapper.updateByPrimaryKeySelective(score1));
        return 1;
    }

    @Override
//    @CacheEvict(key = "#id.get()", allEntries = true)
    public int delete(Optional<Object> id) {
        return id.map(o -> scoreMapper.deleteByPrimaryKey(((ScoreKey) o))).orElse(-1);
    }




    @Override
//    @Cacheable(key = "#id.get()")
    public Optional<Score> queryObject(Optional<Object> id) {
        return id.map(o -> scoreMapper.selectByPrimaryKey((ScoreKey) o));
    }

    @Override
    public Optional<List<Score>> queryList() {
        List<Score> scoresList = scoreMapper.selectByExample(new ScoreExample());
//        log.info("调用一次数据库查询" + scoresList);
        return Optional.ofNullable(scoresList);
    }

    @Override
//    @CachePut(key = "#scoreOptional.get().sno")
    public void saveOrUpdate(Optional<Score> scoreOptional) {
//            TODO
    }


}
