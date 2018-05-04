package com.ulovecode.modules.controller;

import com.ulovecode.common.utils.R;
import com.ulovecode.modules.entity.domain.Course;
import com.ulovecode.modules.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
@Slf4j
public class CourseController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CourseService courseService;

    @RequestMapping("/showList")
    public Optional<List<Course>> showCourse() {
        return courseService.queryList();
    }

    @RequestMapping("/delete/{courseId}")
    public R deleteCourse(@PathVariable("courseId") Optional<Integer> courseId) {
        if (!courseId.isPresent()) {
            return R.error("操作失败");
        }
        courseService.delete(Optional.of(courseId.get()));
        log.info("删除课程号id为" + courseId.get());
        return R.ok("操作成功");
    }


    @RequestMapping("/merge")
    public R saveOrUpdateCourse(@RequestBody Optional<Course> courseForm) {
        if (!courseForm.isPresent()) {
            return R.error("操作失败");
        }
        courseService.saveOrUpdate(courseForm);
        log.info("添加或修改课程号" + courseForm.get());
        return R.ok("操作成功");
    }

    @RequestMapping("/id/{courseId}")
    public R queryById(@PathVariable("courseId") Optional<Integer> courseId) {
        if (!courseId.isPresent()) {
            return R.error("操作失败");
        }
        Optional<Course> course = courseService.queryObject(Optional.of(courseId.get()));
        log.info("查询到" + course.get());
        return R.ok("course", course.get());

    }

}
