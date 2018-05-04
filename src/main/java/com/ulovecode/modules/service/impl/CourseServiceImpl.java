package com.ulovecode.modules.service.impl;

import com.ulovecode.common.utils.RedisUtils;
import com.ulovecode.modules.dao.CourseMapper;
import com.ulovecode.modules.entity.domain.Course;
import com.ulovecode.modules.entity.domain.CourseExample;
import com.ulovecode.modules.enums.ResultEnum;
import com.ulovecode.modules.exception.CourseException;
import com.ulovecode.modules.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * @author JackZhu
 */
@Slf4j
@Service
@CacheConfig(cacheNames = "course")
public class CourseServiceImpl implements CourseService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private  CourseMapper courseMapper;

    @Autowired
    private RedisUtils redisUtils;


    @Override
    @CachePut(key = "#course.get().courseId")
    public void save(Optional<Course> course) {
        course.ifPresent(course1 -> {
            courseMapper.insertSelective(course1);
        });
    }




    @Override
    @CachePut(key = "#course.get().courseId")
    public int update(Optional<Course> course) {
        course.ifPresent(course1 -> courseMapper.updateByPrimaryKeySelective(course1));
        return 1;
    }

    @Override
    @CacheEvict(key = "#id.get()", allEntries = true)
    public int delete(Optional<Object> id) {
        return id.map(o -> courseMapper.deleteByPrimaryKey(((Integer) o))).orElse(-1);
    }



    @Override
    @Cacheable(key = "#id.get()")
    public Optional<Course> queryObject(Optional<Object> id) {
        return id.map(o -> courseMapper.selectByPrimaryKey((Integer) o));
    }

    @Override
//    @Cacheable
//    @Caching
    public Optional<List<Course>> queryList() {
        List<Course> coursesList = courseMapper.selectByExample(new CourseExample());
        log.debug("调用一次数据库查询" + coursesList);
        return Optional.ofNullable(coursesList);
    }

    @Override
//    @CacheEvict(key = "#courseOptional.get().courseId")
    public void saveOrUpdate(Optional<Course> courseOptional) {
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            if (course.getCourseId() != null) {
                update(courseOptional);
            } else {
                save(courseOptional);
            }
        }

    }
}
