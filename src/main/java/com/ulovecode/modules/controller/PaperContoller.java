package com.ulovecode.modules.controller;


import com.ulovecode.common.utils.R;
import com.ulovecode.modules.dao.CourseMapper;
import com.ulovecode.modules.entity.domain.Course;
import com.ulovecode.modules.entity.domain.Paper;
import com.ulovecode.modules.service.CourseService;
import com.ulovecode.modules.service.PaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paper")
@Slf4j
public class PaperContoller {
    @Autowired
    PaperService paperService;
    @Autowired
    CourseService courseService;

    @RequestMapping("/showList")
    public Optional<List<Paper>> showPaper() {
        return paperService.queryList();
    }

    @RequestMapping("/delete/{paperId}")
    public R deletePaper(@PathVariable("paperId") Optional<Integer> paperId) {
        try {
            paperService.delete(Optional.of(paperId.get()));
            log.info("删除试卷号id为" + paperId.get());
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("删除失败,试卷号id为" + paperId.get() + "编号的试卷");
            return R.error("操作失败");
        }
        return R.ok("操作成功");
    }


    @RequestMapping("/merge")
    public R saveOrUpdatePaper(@RequestBody Optional<Paper> paperForm) {
        try {
            paperService.saveOrUpdate(paperForm);
            log.info("添加或修改试卷号" + paperForm.get());
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("添加或修改,试卷为" + paperForm.get() + "的试卷");
            return R.error("操作失败");
        }
        return R.ok("操作成功");
    }

    @RequestMapping("/id/{paperId}")
    public R queryById(@PathVariable("paperId") Optional<Integer> paperId) {
        try {
            Optional<Paper> paper = paperService.queryObject(Optional.of(paperId.get()));
            log.info("查询到" + paper.get());
            return R.ok("paper", paper.get());
        } catch (Exception e) {
            e.printStackTrace();
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
