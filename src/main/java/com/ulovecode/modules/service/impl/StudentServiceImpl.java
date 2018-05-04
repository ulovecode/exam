package com.ulovecode.modules.service.impl;

import com.ulovecode.common.utils.RedisUtils;
import com.ulovecode.modules.dao.StudentMapper;
import com.ulovecode.modules.entity.domain.Student;
import com.ulovecode.modules.entity.domain.StudentExample;
import com.ulovecode.modules.enums.ResultEnum;
import com.ulovecode.modules.exception.StudentException;
import com.ulovecode.modules.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * @author JackZhu
 */
@Slf4j
@Service
@CacheConfig(cacheNames = "student")
public class StudentServiceImpl implements StudentService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private  RedisUtils redisUtils;


    @Override
//    @CachePut(key = "#student.get().sno")
    public void save(Optional<Student> student) {
            student.ifPresent(student1 -> {
                studentMapper.insertSelective(student1);
            });

    }


    @Override
//    @CachePut(key = "#student.get().sno")
    public int update(Optional<Student> student) {
            student.ifPresent(student1 -> studentMapper.updateByPrimaryKeySelective(student1));
        return 1;
    }

    @Override
//    @CacheEvict(key = "#id.get()", allEntries = true)
    public int delete(Optional<Object> id) {
        return id.map(o -> studentMapper.deleteByPrimaryKey(((String) o))).orElse(-1);
    }



    @Override
//    @Cacheable(key = "#id.get()")
    public Optional<Student> queryObject(Optional<Object> id) {
        return id.map(o -> studentMapper.selectByPrimaryKey((String) o));
    }

    @Override
    public Optional<List<Student>> queryList() {
        List<Student> studentsList = studentMapper.selectByExample(new StudentExample());
//        log.info("调用一次数据库查询" + studentsList);
        return Optional.ofNullable(studentsList);
    }

    @Override
//    @CachePut(key = "#studentOptional.get().sno")
    public void saveOrUpdate(Optional<Student> studentOptional) {
        if (studentOptional.isPresent()) {
            if (!queryObjectByIdNoAndSno(studentOptional).equals(Optional.empty())) {
                 update(studentOptional);
            }else {
                save(studentOptional);
            }
        }

    }

    @Override
    public Optional<Student> queryObjectByIdNoAndSno(Optional<Student> studentOptional) {
        return studentOptional.map(student -> studentMapper.queryObjectByIdNoAndSno(student));
    }
}
