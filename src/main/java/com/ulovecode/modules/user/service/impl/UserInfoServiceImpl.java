package com.ulovecode.modules.user.service.impl;

import com.ulovecode.common.utils.RedisUtils;
import com.ulovecode.modules.user.dao.UserInfoMapper;
import com.ulovecode.modules.user.entity.UserInfo;
import com.ulovecode.modules.user.entity.UserInfoExample;
import com.ulovecode.modules.user.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@CacheConfig(cacheNames = "userinfo")
public class UserInfoServiceImpl implements UserInfoService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserInfoMapper userinfoMapper;

    @Autowired
    private RedisUtils redisUtils;


    @Override
//    // @CachePut(key = "#userinfo.get().sno")
    public void save(Optional<UserInfo> userinfo) {
        userinfo.ifPresent(userinfo1 -> {
            userinfoMapper.insertSelective(userinfo1);
        });

    }


    @Override
//    // @CachePut(key = "#userinfo.get().sno")
    public int update(Optional<UserInfo> userinfo) {
        userinfo.ifPresent(userinfo1 -> userinfoMapper.updateByPrimaryKeySelective(userinfo1));
        return 1;
    }

    @Override
//    @CacheEvict(key = "#id.get()", allEntries = true)
    public int delete(Optional<Object> id) {
        return id.map(o -> userinfoMapper.deleteByPrimaryKey(((String) o))).orElse(-1);
    }



    @Override
//   // @Cacheable(key = "#id.get()")
    public Optional<UserInfo> queryObject(Optional<Object> id) {
        return id.map(o -> userinfoMapper.selectByPrimaryKey((String) o));
    }

    @Override
    public Optional<List<UserInfo>> queryList() {
        List<UserInfo> userinfosList = userinfoMapper.selectByExample(new UserInfoExample());
//        log.info("调用一次数据库查询" + userinfosList);
        return Optional.ofNullable(userinfosList);
    }

    @Override
//    // @CachePut(key = "#userinfoOptional.get().sno")
    public void saveOrUpdate(Optional<UserInfo> userinfoOptional) {
        if (userinfoOptional.isPresent()) {
            if (userinfoOptional.get().getUserid() != null) {
                update(userinfoOptional);
            }else {
                save(userinfoOptional);
            }
        }

    }


}
