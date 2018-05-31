package com.ulovecode.modules.answer.controller;

import com.ulovecode.common.utils.R;
import com.ulovecode.modules.answer.entity.PaperAnswer;
import com.ulovecode.modules.answer.service.PaperAnswerService;
import com.ulovecode.modules.item.entity.Item;
import com.ulovecode.modules.item.service.ItemService;
import com.ulovecode.modules.paper.entity.Paper;
import com.ulovecode.modules.paper.service.PaperService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/answer")
@RestController
@Slf4j
@Api("试卷答案的相关接口")
@ApiResponses({@ApiResponse(code = 0, message = "正常码"), @ApiResponse(code = 500, message = "服务器处理错误")})
public class AnswerController {
    @Autowired
    PaperAnswerService paperAnswerService;

    @Autowired
    ItemService itemService;

    @Autowired
    PaperService paperService;

    @ApiOperation(value = "保存学生提交答案",response = R.class)
    @PostMapping(value = "/save")
    public R examAnswerSave(@RequestBody  @ApiParam(value = "用户的答案", required = true) ArrayList<PaperAnswer> answers) {
        paperAnswerService.saveBatch(Optional.ofNullable(answers));
        Optional<Paper> paper = paperService.queryObject(Optional.ofNullable(answers.get(0).getSno()));
        paper.ifPresent(paper1 -> paperService.update(paper.map(paper2 -> paper2.setPstatus("正考完"))));
        return R.ok("提交答案成功");
    }

    @GetMapping("/itemlist")
    public R examItem(Integer paperId) {
        Optional<List<Item>> itemList = itemService.findByPaperId(Optional.ofNullable(paperId));
        return R.ok().put("data", itemList);
    }


    @GetMapping("/examlist")
    public R examlist() {
        List<Paper> papers = paperService.paperListOrderByDate();
        return R.ok("data", papers);
    }


}
