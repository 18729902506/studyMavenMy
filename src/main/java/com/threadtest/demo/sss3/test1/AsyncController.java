package com.threadtest.demo.sss3.test1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/***
 * controller的执行线程是”nio-8080-exec-8”，这是tomcat的执行线程，
 * 而service层的日志显示线程名为“async-service-1”，
 * 显然已经在我们配置的线程池中执行了，并且每次请求中，controller的起始和结束日志都是连续打印的，表明每次请求都快速响应了，而耗时的操作都留给线程池中的线程去异步执行；
 * @author shang
 */
@RestController
public class AsyncController {

    private static final Logger logger = LoggerFactory.getLogger(AsyncController.class);

    @Resource
    private AsyncService asyncService;

    @RequestMapping("/")
    public String submit(){
        logger.info("start submit");
        // 做好了一个http请求的服务，里面做的事情其实是同步的，接下来我们就开始配置springboot的线程池服务，将service层做的事情都提交到线程池中去处理，
        // 调用service层的任务
        asyncService.executeAsync();
        logger.info("end submit");
        return "success";
    }
}
