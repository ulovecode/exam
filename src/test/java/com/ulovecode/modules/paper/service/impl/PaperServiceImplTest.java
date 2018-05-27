package com.ulovecode.modules.paper.service.impl;

import com.ulovecode.SpringbootMybatisDemoApplication;
import com.ulovecode.modules.paper.entity.Paper;
import com.ulovecode.modules.paper.service.PaperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class PaperServiceImplTest {

    @Autowired
    PaperService paperService;

    @Test
    public void deleteWithCascade() {
//        paperService.deleteWithCascade(Optional<Integer>.of(21));

    }

    @Test
    public void addWitCascade() {
        Paper paper =
                new Paper().setCourseId(61)
                .setDescript("31223")
                .setGrade("312")
                .setPapertime(new Date())
                .setStage("1223")
                .setTestdate(new Date())
                .setTitle("2131");

        paperService.addWitCascade(Optional.of(paper));

    }
}