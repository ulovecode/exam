package com.ulovecode.modules.paper.controller;


import com.ulovecode.common.utils.R;
import com.ulovecode.modules.course.entity.Course;
import com.ulovecode.modules.paper.entity.Paper;
import com.ulovecode.modules.course.service.CourseService;
import com.ulovecode.modules.paper.service.PaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@RestController
@RequestMapping("/paper")
@Slf4j
public class PaperContoller {
    @Autowired
    private PaperService paperService;
    @Autowired
    private CourseService courseService;

    @RequestMapping("/showList")
    public Optional<List<Paper>> showPaper() {
        return paperService.queryList();
    }

    @RequestMapping("/delete/{paperId}")
    public R deletePaper(@PathVariable("paperId") OptionalInt paperId) {
        if (!paperId.isPresent()) {
            return R.error("操作失败");
        }
        paperService.deleteWithCascade(paperId);
        log.info("删除试卷号id为" + paperId);
        return R.ok("删除试卷成功");
    }


    @RequestMapping("/merge")
    public R saveOrUpdatePaper(@RequestBody Optional<Paper> paperForm) {
        if (!paperForm.isPresent()) {
            return R.error("操作失败");
        }
        paperService.saveOrUpdate(paperForm);
        log.info("添加或修改试卷号" + paperForm.get());
        return R.ok("操作成功");
    }

    @RequestMapping("/id/{paperId}")
    public R queryById(@PathVariable("paperId") Optional<Integer> paperId) {
        if (!paperId.isPresent()) {
            return R.error("操作失败");
        }
        Optional<Paper> paper = paperService.queryObject(Optional.of(paperId.get()));
        if (paper.isPresent()) {
            log.info("查询到" + paper.get());
            return R.ok("paper", paper.get());
        } else {
            log.debug("查询到失败,试卷为" + paperId.get() + "的试卷");
            return R.error("操作失败");
        }

    }

    @RequestMapping("/presave")
    public R preSave() {
        Optional<List<Course>> courses = courseService.queryList();
        if (courses.equals(Optional.empty())) {
            return R.error(500, "请先创建一门试卷");
        }
        return R.ok("course", courses);
    }

}
