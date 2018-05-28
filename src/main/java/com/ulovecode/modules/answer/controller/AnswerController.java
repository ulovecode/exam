package com.ulovecode.modules.answer.controller;

import com.ulovecode.common.utils.R;
import com.ulovecode.modules.answer.entity.PaperAnswer;
import com.ulovecode.modules.answer.service.PaperAnswerService;
import com.ulovecode.modules.item.entity.Item;
import com.ulovecode.modules.item.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @RequestMapping("/save")
    public R examAnswerSave(List<PaperAnswer> answer) {
        paperAnswerService.saveBatch(Optional.ofNullable(answer));
        return R.ok("提交答案成功");
    }

    @RequestMapping("/presave")
    public R examItem(Integer paperId) {
        Optional<List<Item>> itemList = itemService.findByPaperId(Optional.ofNullable(paperId));
        return R.ok().put("data", itemList);
    }





}
