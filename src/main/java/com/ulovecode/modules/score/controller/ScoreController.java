package com.ulovecode.modules.score.controller;


import com.ulovecode.common.utils.R;
import com.ulovecode.modules.paper.service.PaperService;
import com.ulovecode.modules.score.entity.Score;
import com.ulovecode.modules.score.service.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @ApiOperation(value = "查询当前学生考了多少分数")
    @GetMapping(value = "/list")
    public R list(@RequestBody Optional<String> snoOptional) {
        if (snoOptional.isPresent()) {
            String sno = snoOptional.get();
            Optional<List<Score>> scores = scoreService.queryList();
            if (scores.isPresent()) {
                List<Score> scorelistBySno = scores.get().stream()
                        .filter(score -> score.getSno().equals(sno))
                        .collect(Collectors.toList());

                return R.ok("data", scorelistBySno);
            }
        }
        return R.ok();
    }

}
