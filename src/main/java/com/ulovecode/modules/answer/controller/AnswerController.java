package com.ulovecode.modules.answer.controller;

import com.ulovecode.common.utils.R;
import com.ulovecode.modules.answer.entity.PaperAnswer;
import com.ulovecode.modules.answer.service.PaperAnswerService;
import com.ulovecode.modules.item.entity.Item;
import com.ulovecode.modules.item.service.ItemService;
import com.ulovecode.modules.paper.entity.Paper;
import com.ulovecode.modules.paper.service.PaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/answer")
@RestController
@Slf4j
public class AnswerController {
    @Autowired
    PaperAnswerService paperAnswerService;

    @Autowired
    ItemService itemService;

    @Autowired
    PaperService paperService;


    @RequestMapping(value = "/save")
    public R examAnswerSave(@RequestBody ArrayList<PaperAnswer> answers) {
        paperAnswerService.saveBatch(Optional.ofNullable(answers));
        return R.ok("提交答案成功");
    }

    @RequestMapping("/presave")
    public R examItem(Integer paperId) {
        Optional<List<Item>> itemList = itemService.findByPaperId(Optional.ofNullable(paperId));
        return R.ok().put("data", itemList);
    }


    @RequestMapping("/examlist")
    public R examlist() {
        List<Paper> papers = paperService.paperListOrderByDate();
        return R.ok("data", papers);
    }



}
