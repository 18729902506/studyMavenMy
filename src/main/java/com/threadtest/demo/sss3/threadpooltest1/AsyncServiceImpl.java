package com.threadtest.demo.sss3.threadpooltest1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/***
 * ExecutorConfig中的方法名称为：asyncServiceExecutor
 * 表明executeAsync()方法进入的线程池是asyncServiceExecutor()创建的
 * @author shang
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Async("asyncServiceExecutor")
    @Override
    public void executeAsync() {
        logger.info("start executeAsync");
        try {
            //睡一秒钟
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("end executeAsync");
    }
}
