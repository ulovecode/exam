package com.ulovecode.common.scheduled;

import com.ulovecode.modules.answer.entity.PaperAnswer;
import com.ulovecode.modules.answer.entity.PaperAnswerKey;
import com.ulovecode.modules.answer.service.PaperAnswerService;
import com.ulovecode.modules.item.entity.Item;
import com.ulovecode.modules.item.service.ItemService;
import com.ulovecode.modules.paper.entity.Paper;
import com.ulovecode.modules.paper.service.PaperService;
import com.ulovecode.modules.score.entity.Score;
import com.ulovecode.modules.score.service.ScoreService;
import com.ulovecode.modules.student.entity.Student;
import com.ulovecode.modules.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.jws.Oneway;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class ScheduledTaskService {

    private Lock lock = new ReentrantLock();

    @Autowired
    PaperService paperService;
    @Autowired
    PaperAnswerService paperAnswerService;
    @Autowired
    StudentService studentService;
    @Autowired
    ItemService itemService;

    @Autowired
    ScoreService scoreService;

    @Scheduled(fixedRate = 10000) //1
    public void changePstatus() {
        if (lock.tryLock()) {
            try {
                paperService.ChangePstatus();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    /**
     * 自动计算每个学生分数
     */
    @Scheduled(fixedRate = 100000)
    public void countScore() {
        if (lock.tryLock()) {
            try {
                paperAnswerService.queryList().ifPresent(answerList -> answerList.forEach(paperAnswer -> {
                    Integer paperId = paperAnswer.getPaperId();
                    HashSet<String> userSets = Arrays.stream(paperAnswer.getAnswer().split(","))
                            .filter(s -> !s.equals(""))
                            .collect(Collectors.toCollection(HashSet::new));
                    Integer itemId = paperAnswer.getItemId();
                    Optional<Item> item = itemService.queryObject(Optional.of(itemId));
                    Optional<String[]> strings = item.map(Item::getAnswer)
                            .map(s -> s.split(","));
                    if (strings.isPresent()) {
                        String[] answers = strings.get();
                        HashSet<String> answerSets = Arrays.stream(answers)
                                .filter(s -> !s.equals(""))
                                .collect(Collectors.toCollection(HashSet::new));
                        int score = 0;
                        int correct = 0;
                        int ansum = 0;
                        for (String userSet : userSets) {
                            if (answerSets.contains(userSet)) {
                                score += 20;
                                correct += 1;
                            }
                            ansum += 1;
                        }
                        Score saveScore = new Score();
                        saveScore.setScore(score);
                        saveScore.setPaperId(paperId);
                        saveScore.setSno(paperAnswer.getSno());
                        saveScore.setAnsnum(ansum);
                        saveScore.setCorrect(correct);
                        scoreService.save(Optional.of(saveScore));
                    }
                }));
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        }
    }


/*
1．秒（0–59）
2．分钟（0–59）
3．小时（0–23）
4．月份中的日期（1–31）
5．月份（1–12或JAN–DEC）
6．星期中的日期（1–7或SUN–SAT）
7．年份（1970–2099）
*/
//	  @Scheduled(cron = "* 02-30 17 ? 1 *"  ) //2
//	  public void fixTimeExecution(){
//	      System.out.println("在指定时间 " + dateFormat.format(new Date())+"执行");
//	  }

}
