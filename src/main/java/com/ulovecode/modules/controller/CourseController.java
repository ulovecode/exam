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
    CourseService courseService;

    @RequestMapping("/showList")
    public Optional<List<Course>> showCourse() {
        return courseService.queryList();
    }

    @RequestMapping("/delete/{courseId}")
    public R deleteCourse(@PathVariable("courseId") Optional<Integer> courseId) {
        try {
            courseService.delete(Optional.of(courseId.get()));
            log.info("删除课程号id为" + courseId.get());
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("删除失败,课程号id为" + courseId.get() + "编号的课程");
            return R.error("操作失败");
        }
        return R.ok("操作成功");
    }


    @RequestMapping("/merge")
    public R saveOrUpdateCourse(@RequestBody Optional<Course> courseForm) {
        try {
            courseService.saveOrUpdate(courseForm);
            log.info("添加或修改课程号" + courseForm.get());
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("添加或修改,课程为" + courseForm.get() + "的课程");
            return R.error("操作失败");
        }
        return R.ok("操作成功");

    }

    @RequestMapping("/id/{courseId}")
    public R queryById(@PathVariable("courseId") Optional<Integer> courseId) {
        try {
            Optional<Course> course = courseService.queryObject(Optional.of(courseId.get()));
            log.info("查询到" + course.get());
            return R.ok("course", course.get());
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("查询到失败,课程为" + courseId.get() + "的课程");
            return R.error("操作失败");
        }
    }



}
