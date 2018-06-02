package com.ulovecode.modules.student.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.ulovecode.common.utils.R;
import com.ulovecode.modules.student.entity.Student;
import com.ulovecode.modules.student.service.StudentService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@Slf4j
@Api("学生管理接口")
@ApiResponses({@ApiResponse(code = 0, message = "正常码"), @ApiResponse(code = 500, message = "服务器处理错误")})
public class StudentController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private StudentService studentService;

    @ApiOperation("展示学生列表")
    @GetMapping("/showlist")
    public Optional<List<Student>> showStudent() {
        return studentService.queryList();

    }

    @ApiOperation(value = "删除学生",notes = "根据传进来的url的id来删除学生")
    @ApiImplicitParam(value = "学生id",paramType = "path",dataType = "String",name = "sno")
    @DeleteMapping("/id/{sno}")
    public R deleteStudent(@PathVariable("sno") Optional<String> sno) {
        if (!sno.isPresent()) {
            return R.error("操作失败");
        }
        studentService.delete(Optional.of(sno.get()));
        log.info("删除课程号id为" + sno.get());
        return R.ok("操作成功");
    }


    @ApiOperation(value = "增加学生",notes = "传入学生信息")
    @ApiImplicitParam(value = "学生信息",name = "studentForm",dataType = "Student",required = true,paramType = "body")
    @PostMapping("/id")
    public R saveStudent(@RequestBody Optional<Student> studentForm) {
        if (!studentForm.isPresent()) {
            return R.error("操作失败");
        }
        studentService.saveOrUpdate(studentForm);
        log.info("添加或修改课程号" + studentForm.get());
        return R.ok("操作成功");
    }

    @ApiOperation(value = "修改学生",notes = "传入学生信息")
    @ApiImplicitParam(value = "学生信息",name = "studentForm",dataType = "Student",required = true,paramType = "body")
    @PutMapping("/id")
    public R updateStudent(@RequestBody Optional<Student> studentForm) {
        if (!studentForm.isPresent()) {
            return R.error("操作失败");
        }
        studentService.saveOrUpdate(studentForm);
        log.info("添加或修改课程号" + studentForm.get());
        return R.ok("操作成功");
    }
    @ApiOperation(value = "查询学生",notes = "根据传进来的url的id来查询学生")
    @ApiImplicitParam(value = "学生id",paramType = "path",dataType = "String",name = "sno")
    @GetMapping("/id/{sno}")
    public R queryById(@PathVariable("sno") Optional<String> sno) {
        if (!sno.isPresent()) {
            return R.error("操作失败");
        }
        Optional<Student> student = studentService.queryObject(Optional.of(sno.get()));
        log.info("查询到" + student.get());
        return R.ok("student", student.get());
    }


    @ApiOperation(value = "验证学生信息接口",notes = "传入学生信息")
    @ApiImplicitParam(value = "学生信息",name = "student",dataType = "Student",required = true,paramType = "body")

    @PostMapping("/login")
    @JsonView(Student.WithNoPassword.class)
    public R login(@RequestBody Student student) {
        if (student == null) {
            return R.error("请填写账号和密码");
        }
        Optional<Student> studentOptional = studentService.queryObject(Optional.ofNullable(student.getSno()));
        if (studentOptional.isPresent()) {
            Student studentData = studentOptional.orElseGet(Student::new);
            if (studentData.getPasswd() != null) {
                if (studentData.getPasswd().equals(student.getPasswd())) {
                    return R.ok("data", studentData);
                }
            }
        }
        return R.error("账号或密码错误");
    }

}
