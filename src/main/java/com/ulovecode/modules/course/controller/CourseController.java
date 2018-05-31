package com.ulovecode.modules.course.controller;

import com.ulovecode.common.utils.R;
import com.ulovecode.modules.course.entity.Course;
import com.ulovecode.modules.course.service.CourseService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
@Slf4j
@Api("课程管理接口")
@ApiResponses({@ApiResponse(code = 0, message = "正常码"), @ApiResponse(code = 500, message = "服务器处理错误")})
public class CourseController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CourseService courseService;

    @ApiOperation(value = "查询所有课程")
    @GetMapping("/showlist")
    public Optional<List<Course>> showCourse() {
        return courseService.queryList();
    }

    @ApiOperation(value = "" +
            "",notes = "根据url的id来制定删除的对象")
    @ApiImplicitParam(paramType="path", name = "courseId", value ="课程Id", required = true, dataType = "int")
    @DeleteMapping("/id/{courseId}")
    public R deleteCourse(@PathVariable("courseId") Optional<Integer> courseId) {
        if (!courseId.isPresent()) {
            return R.error("操作失败");
        }
        courseService.delete(Optional.of(courseId.get()));
        log.info("删除课程号id为" + courseId.get());
        return R.ok("操作成功");
    }


    @ApiOperation(value = "添加课程",notes = "传入json课程")
    @PostMapping("/id")
    public R saveCourse(@RequestBody  @ApiParam("课程信息") Optional<Course> courseForm) {
        if (!courseForm.isPresent()) {
            return R.error("操作失败");
        }
        courseService.save(courseForm);
        log.info("添加或修改课程号" + courseForm.get());
        return R.ok("操作成功");
    }

    @ApiOperation(value = "修改课程",notes = "传入json课程")
    @PutMapping("/id")
    public R updateCourse(@RequestBody  @ApiParam("课程信息") Optional<Course> courseForm) {
        if (!courseForm.isPresent()) {
            return R.error("操作失败");
        }
        courseService.update(courseForm);
        log.info("添加或修改课程号" + courseForm.get());
        return R.ok("操作成功");
    }


    @ApiOperation(value = "根据id查询",notes = "传入url id来查询课程")
    @ApiImplicitParam(paramType="path",value = "传入课程id",name = "courseId",required = true,dataType = "Integer")
    @GetMapping("/id/{courseId}")
    public R queryById(@PathVariable("courseId")  Optional<Integer> courseId) {
        if (!courseId.isPresent()) {
            return R.error("操作失败");
        }
        Optional<Course> course = courseService.queryObject(Optional.of(courseId.get()));
        log.info("查询到" + course.get());
        return R.ok("course", course.get());

    }

}
