package com.ulovecode.modules.controller;

import com.ulovecode.common.utils.R;
import com.ulovecode.modules.entity.domain.Student;
import com.ulovecode.modules.service.StudentService;
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
    StudentService studentService;

    @RequestMapping("/showList")
    public Optional<List<Student>> showStudent() {
        Optional<List<Student>> students = studentService.queryList();
        return students;

    }

    @RequestMapping("/delete/{studentId}")
    public R deleteStudent(@PathVariable("studentId") Optional<String> studentId) {
        try {
            studentService.delete(Optional.of(studentId.get()));
            log.info("删除课程号id为" + studentId.get());
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("删除失败,课程号id为" + studentId.get() + "编号的课程");
            return R.error("操作失败");
        }
        return R.ok("操作成功");
    }


    @RequestMapping("/merge")
    public R saveOrUpdateStudent(@RequestBody Optional<Student> studentForm) {
        try {
            studentService.saveOrUpdate(studentForm);
            log.info("添加或修改课程号" + studentForm.get());
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("操作失败添加或修改,课程为" + studentForm.get() + "的课程");
            return R.error("操作失败");
        }
        return R.ok("操作成功");
    }

    @RequestMapping("/id/{sno}")
    public R queryById(@PathVariable("sno") Optional<String> studentId) {
        try {
            Optional<Student> student = studentService.queryObject(Optional.of(studentId.get()));
            log.info("查询到" + student.get());
            return R.ok("student", student.get());
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("查询到失败,课程为" + studentId.get() + "的课程");
            return R.error("操作失败");
        }
    }


}
