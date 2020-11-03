package com.threadtest.demo.sss3.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/***
 * 线程池的配置类
 * 处理流程：
 *      当一个任务被提交到线程池时，首先查看线程池的核心线程是否都在执行任务，否就选择一条线程执行任务，是就执行第二步
 *                              查看核心线程池是否已满，不满就创建一条线程执行任务，满了就执行第三步
 *                              查看任务队列是否已满，不满就将任务存储在任务队列中，满了就执行第四步
 *                              查看线程池是否已满，不满就创建一条线程执行任务，满了就按照策略处理无法执行的任务
 *      在ThreadPoolExecutor中表现为：
 *          如果当前运行的线程数 < 核心线程数，那么就创建线程来执行任务，执行时需要获取全局锁
 *          如果运行的线程 >= 核心线程数，那么就把任务加入BlockQueue
 *          如果创建的线程数 > BlockQueue的最大容量，那么创建新线程来执行该任务
 *          如果创建线程导致当前运行的线程数 > 最大线程数，就根据饱和策略来拒绝该任务
 *
 * @author shang
 */
@Configuration
@EnableAsync
public class ExecutorConfig {

    private static final Logger logger = LoggerFactory.getLogger(ExecutorConfig.class);

    @Bean
    public ThreadPoolTaskExecutor asyncServiceExecutor(){
        logger.info("start asyncServiceExecutor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(5);
        //配置最大线程数
        executor.setMaxPoolSize(5);
        //配置队列大小
        executor.setQueueCapacity(99999);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("async-service-");

        //线程池满了，可以配置拒绝策略，AbortPolicy，用于被拒绝任务的处理程序，它将抛出RejectedExecutionException
        //用于配置拒绝策略，    对拒绝任务抛弃处理，并且抛出异常
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        //执行初始化
        executor.initialize();
        return executor;

    }
}
