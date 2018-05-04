package com.ulovecode.common.base;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 基础Dao(还需在XML文件里，有对应的SQL语句)
 *
 * @date 2016年9月18日 上午9:31:36
 */
public interface

BaseService<T> {

    void save(Optional<T> t);

    @Transactional(rollbackFor = Exception.class)
    default void saveBatch(Optional<List<T>> list){
            list.get().forEach(t -> {
                save(Optional.of(t));
            });
    }


    int update(Optional<T> t);


    int delete(Optional<Object> id);

    @Transactional(rollbackFor = Exception.class)
    default int deleteBatch(Optional<Object[]> id){
        if (id.isPresent()) {
            for (int i = 0; i < id.get().length; i++) {
                delete(Optional.of(id.get()[i]));
            }
        }
        return 1;
    }



    Optional<T> queryObject(Optional<Object> id);


    Optional<List<T>> queryList();

    void saveOrUpdate(Optional<T> t);



}
