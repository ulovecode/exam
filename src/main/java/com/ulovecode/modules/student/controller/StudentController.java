package com.ulovecode.modules.student.controller;

import com.ulovecode.common.utils.R;
import com.ulovecode.modules.student.entity.Student;
import com.ulovecode.modules.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private StudentService studentService;

    @RequestMapping("/showlist")
    public Optional<List<Student>> showStudent() {
        return studentService.queryList();

    }

    @RequestMapping("/delete/{studentId}")
    public R deleteStudent(@PathVariable("studentId") Optional<String> studentId) {
        if (!studentId.isPresent()) {
            return R.error("操作失败");
        }
        studentService.delete(Optional.of(studentId.get()));
        log.info("删除课程号id为" + studentId.get());
        return R.ok("操作成功");
    }


    @RequestMapping("/merge")
    public R saveOrUpdateStudent(@RequestBody Optional<Student> studentForm) {
        if (!studentForm.isPresent()) {
            return R.error("操作失败");
        }
        studentService.saveOrUpdate(studentForm);
        log.info("添加或修改课程号" + studentForm.get());
        return R.ok("操作成功");
    }

    @RequestMapping("/id/{sno}")
    public R queryById(@PathVariable("sno") Optional<String> studentId) {
        if (!studentId.isPresent()) {
            return R.error("操作失败");
        }
        Optional<Student> student = studentService.queryObject(Optional.of(studentId.get()));
        log.info("查询到" + student.get());
        return R.ok("student", student.get());
    }


}
