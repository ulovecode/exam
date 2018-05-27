package com.ulovecode.modules.item.service.impl;

import com.ulovecode.common.utils.RedisUtils;
import com.ulovecode.modules.item.dao.ItemMapper;
import com.ulovecode.modules.item.entity.Item;
import com.ulovecode.modules.item.entity.ItemExample;
import com.ulovecode.modules.item.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@CacheConfig(cacheNames = "item")
public class ItemServiceImpl implements ItemService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private RedisUtils redisUtils;


    @Override
//    // @CachePut(key = "#item.get().sno")
    public void save(Optional<Item> item) {
        item.ifPresent(item1 -> {
            itemMapper.insertSelective(item1);
        });

    }


    @Override
//    // @CachePut(key = "#item.get().sno")
    public int update(Optional<Item> item) {
        item.ifPresent(item1 -> itemMapper.updateByPrimaryKeySelective(item1));
        return 1;
    }

    @Override
//    @CacheEvict(key = "#id.get()", allEntries = true)
    public int delete(Optional<Object> id) {
        return id.map(o -> itemMapper.deleteByPrimaryKey(((Integer) o))).orElse(-1);
    }




    @Override
//   // @Cacheable(key = "#id.get()")
    public Optional<Item> queryObject(Optional<Object> id) {
        return id.map(o -> itemMapper.selectByPrimaryKey((Integer) o));
    }

    @Override
    public Optional<List<Item>> queryList() {
        List<Item> itemsList = itemMapper.selectByExample(new ItemExample());
//        log.info("调用一次数据库查询" + itemsList);
        return Optional.ofNullable(itemsList);
    }

    @Override
//    // @CachePut(key = "#itemOptional.get().sno")
    public void saveOrUpdate(Optional<Item> itemOptional) {
        if (itemOptional.isPresent()) {
            if (itemOptional.get().getItemId() != null) {
                update(itemOptional);
            }else {
                save(itemOptional);
            }
        }

    }


}
