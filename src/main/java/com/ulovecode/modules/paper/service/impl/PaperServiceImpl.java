package com.ulovecode.modules.paper.service.impl;

import com.ulovecode.common.utils.RedisUtils;
import com.ulovecode.modules.course.dao.CourseMapper;
import com.ulovecode.modules.paper.dao.PaperMapper;
import com.ulovecode.modules.paper.entity.Paper;
import com.ulovecode.modules.paper.entity.PaperExample;
import com.ulovecode.modules.paper.service.PaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Slf4j
@Service
@CacheConfig(cacheNames = "paper")
public class PaperServiceImpl implements PaperService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")

    @Autowired
    PaperMapper paperMapper;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    CourseMapper courseMapper;

    @Autowired
    RedisUtils redisUtils;

    @Override
    @CachePut(key = "#paper.get().paperId")
    public void save(Optional<Paper> paper) {
        paper.ifPresent(paper1 -> {
            paperMapper.insertSelective(paper1);
        });
    }

    @Override
    @CachePut(key = "#paper.get().paperId")
    public int update(Optional<Paper> paper) {
        paper.ifPresent(paper1 -> paperMapper.updateByPrimaryKeySelective(paper1));
        return 1;
    }

    @Override
    @CacheEvict(key = "#id.get()", allEntries = true)
    public int delete(Optional<Object> id) {
        return id.map(o -> paperMapper.deleteByPrimaryKey(((Integer) o))).orElse(-1);
    }



    @Override
    @Cacheable(key = "#id.get()")
    public Optional<Paper> queryObject(Optional<Object> id) {
        return id.map(o -> paperMapper.selectByPrimaryKey((Integer) o));
    }

    @Override
//    @Cacheable
//    @Caching
    public Optional<List<Paper>> queryList() {
        List<Paper> papersList = paperMapper.selectByExample(new PaperExample());
        log.debug("调用一次数据库查询" + papersList);
        return Optional.ofNullable(papersList);
    }

    @Override
//    @CacheEvict(key = "#paperOptional.get().paperId")
    public void saveOrUpdate(Optional<Paper> paperOptional) {
        if (paperOptional.isPresent()) {
            Paper paper = paperOptional.get();
            if (paper.getPaperId() != null) {
                update(paperOptional);
            } else {
                addWitCascade(paperOptional);
            }
        }
    }



    @Override
    public void deleteWithCascade(OptionalInt paperIdOptional) {
        paperIdOptional.ifPresent(integer -> paperMapper.deleteWithCascade(integer));
    }

    @Override
    public void addWitCascade(Optional<Paper> recordOptional) {
        recordOptional.ifPresent(paper -> paperMapper.addWitCascade(paper));
    }
}
