package com.example;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    //记录器
    Logger logger =  LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads(){
        /**
         * 日志级别由低到高
         * trace<debugger<info<warn<errro
         */
        logger.trace("这是trace日志");
        logger.debug("这是debug日志");
        //springBoot默认给我们使用的是info级别 不特殊指定 用默认的
        logger.info("这是info日志");
        logger.warn("这是warn日志");
        logger.error("这是error日志");
    }

}
