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
@Api("试卷答案的相关接口")
public class AnswerController {
    @Autowired
    PaperAnswerService paperAnswerService;

    @Autowired
    ItemService itemService;

    @Autowired
    PaperService paperService;

    @ApiOperation(value = "保存学生提交答案",response = R.class)
//    @ApiImplicitParam(paramType = "query", name = "anwers", value Zz= "试卷答案集合", required = true, dataType = "ArrayList<PaperAnswer>")
    @ApiResponses({@ApiResponse(code = 0, message = "正常码"), @ApiResponse(code = 500, message = "服务器处理错误")})
    @RequestMapping(value = "/save")
    public R examAnswerSave(@RequestBody  @ApiParam(value = "用户的答案", required = true) ArrayList<PaperAnswer> answers) {
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
