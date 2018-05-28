package com.ulovecode.modules.answer;

import com.ulovecode.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/answer")
@RestController
@Slf4j
public class AnswerController {

    @RequestMapping("/examitem")
    public R examItem(){
        return R.ok();    }

}
