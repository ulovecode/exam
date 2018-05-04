package com.ulovecode.common.aspect;

import com.ulovecode.common.exception.RRException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Redis切面处理类
 *
 * @author jackzhu
 * @email 435999799@qq.com
 * jackzhu
 */
@Aspect
@Configuration
@Slf4j
public class RedisAspect {
    //是否开启redis缓存  true开启   false关闭
    @Value("${spring.redis.open: #{true}}")
    private boolean open;

    @Around("execution(* com.ulovecode.common.utils.RedisUtils.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        if(open){
            try{
                result = point.proceed();
                log.info("从redis中查询到了"+result);
            }catch (Exception e){
                log.error("redis error", e);
                throw new RRException("Redis服务异常");
            }
        }
        return result;
    }
}
