package com.ulovecode.common.scheduled;

import com.ulovecode.modules.paper.service.PaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
@Slf4j
public class ScheduledTaskService {

	private Lock lock = new ReentrantLock();

	@Autowired
	PaperService paperService;

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
