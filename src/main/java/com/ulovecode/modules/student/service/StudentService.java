package com.ulovecode.modules.student.service;

import com.ulovecode.common.base.BaseService;
import com.ulovecode.modules.student.entity.Student;

import java.util.Optional;

public interface StudentService extends BaseService<Student> {

    Optional<Student>
    queryObjectByIdNoAndSno(Optional<Student> studentOptional);
}
