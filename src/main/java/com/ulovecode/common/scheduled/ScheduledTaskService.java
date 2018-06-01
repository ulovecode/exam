package com.ulovecode.common.scheduled;

import com.ulovecode.modules.answer.service.PaperAnswerService;
import com.ulovecode.modules.item.entity.Item;
import com.ulovecode.modules.item.service.ItemService;
import com.ulovecode.modules.paper.service.PaperService;
import com.ulovecode.modules.score.entity.Score;
import com.ulovecode.modules.score.entity.ScoreKey;
import com.ulovecode.modules.score.service.ScoreService;
import com.ulovecode.modules.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

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
                HashMap<ScoreKey, Score> map = new HashMap<>();
                paperAnswerService.queryList().ifPresent(answerList -> answerList.forEach(paperAnswer -> {
                    Integer paperId = paperAnswer.getPaperId();
                    String sno = paperAnswer.getSno();
                    ScoreKey scoreKey = new ScoreKey(paperId, sno);
                    Score saveScore = null;
                    if (!map.containsKey(scoreKey)) {
                        saveScore = new Score();
                        saveScore.setPaperId(paperId);
                        saveScore.setSno(sno);
                        map.put(scoreKey, saveScore);

                    } else {
                        saveScore = map.get(scoreKey);
                        map.put(scoreKey, saveScore);
                    }


                    //多选题用户答案集合
                    HashSet<String> userSets = Arrays.stream(paperAnswer.getAnswer().split(","))
                            .filter(s -> !s.equals(""))
                            .collect(Collectors.toCollection(HashSet::new));
                    Integer itemId = paperAnswer.getItemId();
                    Optional<Item> item = itemService.queryObject(Optional.of(itemId));
                    Optional<String[]> strings = item.map(Item::getAnswer)
                            .map(s -> s.split(","));
                    boolean isTrue = true;
                    if (strings.isPresent()) {
                        String[] answers = strings.get();
                        //标准答案集合
                        HashSet<String> answerSets = Arrays.stream(answers)
                                .filter(s -> !s.equals(""))
                                .collect(Collectors.toCollection(HashSet::new));
                        for (String userSet : userSets) {
                            if (!answerSets.contains(userSet)) {
                                isTrue = false;
                            }
                        }
                    }
                    if (isTrue) {
                        saveScore.setCorrect(saveScore.getCorrect() + 1);
                        saveScore.setScore(saveScore.getScore() + 20);
                    }
                    saveScore.setAnsnum(saveScore.getAnsnum()+1);
                }));
                map.forEach((scoreKey, score) -> {
                    scoreService.save(Optional.of(score));
                });
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
