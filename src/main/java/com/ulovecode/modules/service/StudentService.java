package com.ulovecode.modules.service;

import com.ulovecode.common.base.BaseService;
import com.ulovecode.modules.entity.domain.Student;

import java.util.Optional;

public interface StudentService extends BaseService<Student> {

    Optional<Student> queryObjectByIdNoAndSno(Optional<Student> studentOptional);
}
