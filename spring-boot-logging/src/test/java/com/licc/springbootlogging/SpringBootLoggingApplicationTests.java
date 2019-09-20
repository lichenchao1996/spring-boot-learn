package com.licc.springbootlogging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootLoggingApplicationTests {

    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {
        //System.out.println();

        //日志的级别 由低到高 trace<debug<info<warn<error
        //可以调整输出的日志级别,日志就只会在这个级别及以后的高级别生效
        //跟踪轨迹
        logger.trace("这是trace日志...");
        //调试
        logger.debug("这是debug日志...");
        //SpringBoot默认使用的是info级别的,没有指定级别的,就用SpringBoot默认的级别:root级别
        //信息
        logger.info("这是info日志...");
        //警告
        logger.warn("这是warn日志...");
        //错误
        logger.error("这是error日志");
    }

}
