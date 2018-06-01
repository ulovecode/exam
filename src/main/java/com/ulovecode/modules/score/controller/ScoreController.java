package com.ulovecode.modules.score.controller;


import com.ulovecode.common.utils.R;
import com.ulovecode.modules.paper.entity.Paper;
import com.ulovecode.modules.paper.service.PaperService;
import com.ulovecode.modules.score.entity.Score;
import com.ulovecode.modules.score.service.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/score")
@Slf4j
@Api("分数管理的Api接口")
public class ScoreController {


    @Autowired
    private ScoreService scoreService;
    @Autowired
    private PaperService paperService;

    @ApiOperation(value = "查询当前学生考了多少分数")
    @ApiImplicitParam(paramType = "query",value = "学生学号",dataType = "String",name = "sno",required = true)
    @GetMapping(value = "/list")
    public R list(@RequestParam(value = "sno") Optional<String> snoOptional) {
        HashMap<Object, Object> resultMap = new HashMap<>();
        if (snoOptional.isPresent()) {
            String sno = snoOptional.get();
            Optional<List<Score>> scores = scoreService.queryList();
            if (scores.isPresent()) {
                List<Score> scorelistBySno = scores.get().stream()
                        .filter(score -> score.getSno().equals(sno))
                        .collect(Collectors.toList());
                List list = new ArrayList();
                for (Score score : scorelistBySno) {
                    Optional<Paper> paper = paperService.queryObject(Optional.of(score.getPaperId()));
                    paper.ifPresent(list::add);
                }
                resultMap.put("scoreList", scorelistBySno);
                resultMap.put("titleList", list);
                return R.ok("data", resultMap);
            }
        }
        return R.ok();
    }

}
