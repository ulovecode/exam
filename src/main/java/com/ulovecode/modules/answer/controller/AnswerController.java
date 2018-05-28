package com.ulovecode.modules.answer.controller;

import com.ulovecode.common.utils.R;
import com.ulovecode.modules.answer.entity.PaperAnswer;
import com.ulovecode.modules.answer.service.PaperAnswerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/answer")
@RestController
@Slf4j
public class AnswerController {
    @Autowired
    PaperAnswerService paperAnswerService;


//    @RequestMapping("/examitem")
//    public R examItem(List<PaperAnswer> answer) {
//
//        paperAnswerService.save();
//    }

}
