package com.ulovecode.modules.paper.controller;


import com.ulovecode.common.utils.R;
import com.ulovecode.common.utils.RR;
import com.ulovecode.modules.course.entity.Course;
import com.ulovecode.modules.item.entity.Item;
import com.ulovecode.modules.item.service.ItemService;
import com.ulovecode.modules.paper.entity.Paper;
import com.ulovecode.modules.course.service.CourseService;
import com.ulovecode.modules.paper.service.PaperService;
import com.ulovecode.modules.student.entity.Student;
import com.ulovecode.modules.student.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/paper")
@Slf4j
@Api("试卷管理的api接口")
public class PaperController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private PaperService paperService;
    @Autowired
    private CourseService courseService;

    @ApiOperation(value = "试卷列表")
    @GetMapping("/showlist")
    public Optional<List<Paper>> showPaper() {
        return paperService.queryList();
    }


    @ApiOperation(value = "删除试卷", notes = "根据url传入的id删除试卷")
    @ApiImplicitParam(paramType = "path",value = "试卷id",name = "paperId",dataType = "int")
    @DeleteMapping("/id/{paperId}")
    public R deletePaper(@PathVariable("paperId") Optional<Integer> paperId) {
        if (!paperId.isPresent()) {
            return R.error("操作失败");
        }
        paperService.deleteWithCascade(paperId);
        log.info("删除试卷号id为" + paperId);
        return R.ok("删除试卷成功");
    }

    @ApiOperation(value = "保存试卷")
    @ApiImplicitParam(value = "试卷信息",name = "paperForm",dataType = "Paper")
    @PostMapping("/id")
    public R savePaper(@RequestBody Optional<Paper> paperForm) {
        if (!paperForm.isPresent()) {
            return R.error("操作失败");
        }
        paperService.save(paperForm);
        log.info("添加或修改试卷号" + paperForm.get());
        return R.ok("操作成功");
    }
    @ApiOperation(value="更新试卷")
    @ApiImplicitParam(value = "试卷信息",name = "paperForm",dataType = "Paper")
    @PutMapping("/id")
    public R updatePaper(@RequestBody Optional<Paper> paperForm) {
        if (!paperForm.isPresent()) {
            return R.error("操作失败");
        }
        paperService.update(paperForm);
        log.info("添加或修改试卷号" + paperForm.get());
        return R.ok("操作成功");
    }

    @ApiOperation(value = "查询某个试卷", notes = "根据url传入的id查询试卷")
    @ApiImplicitParam(paramType = "path",value = "试卷id",name = "paperId",dataType = "int")
    @GetMapping("/id/{paperId}")
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

    @ApiOperation(value = "查询试卷列表")
    @GetMapping("/presave")
    public R preSave() {
        Optional<List<Course>> courses = courseService.queryList();
        if (courses.equals(Optional.empty())) {
            return R.error(500, "请先创建一门试卷");
        }
        return R.ok("course", courses);
    }

/*
    @ApiOperation(value = "查询当前学生当前试卷的试题列表")
    @GetMapping("/info/{paperId}")
    public RR examInfoBySno(@PathVariable Optional<Integer> paperId, Optional<String> studentId) {
        Student student = null;
        List<Item> itemList = null;
        Paper paper = null;

        if (studentId.isPresent()) {
            student = studentService.queryObject(studentId.map(integer -> ((Object) integer))).orElseGet(Student::new);
            log.info("查询到学生信息:"+student);
        }
        if (paperId.isPresent()) {
            paper = paperService.queryObject(paperId.map(integer -> ((Object) integer))).orElseGet(Paper::new);
            itemList = paperService.findByPaperId(paperId.map(integer -> ((Object) integer)));
            log.info("查询到paper:"+paper);
            log.info("查询到itemList:"+itemList);
        }
        return Objects.requireNonNull(RR.ok().dataPut("student", student).dataPut("paper", paper).dataPut("itemList", itemList));
    }
*/

    @ApiOperation(value = "更改状态", notes = "根据paperId更改试卷状态")
    @ApiImplicitParam(paramType = "query",value = "试卷id",name = "paperId",dataType = "int")
    @GetMapping("/changestatus")
    public R changeStatus( Integer paperId) {
        if(paperId == null)  return   R.error("更新失败");
        Optional<Paper> paper = paperService.queryObject(Optional.ofNullable(paperId));
        Optional<Paper> paperUpdate = paper.map(paper1 -> {
            paper1.setPstatus("启用");
            return paper1;
        });
        int result = paperService.update(paperUpdate);
        log.info("改变状态");
        if (result != 1) {
            R.error("更新失败");
        }
        return R.ok("更新成功");
    }
}
