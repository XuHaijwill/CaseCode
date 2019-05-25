package com.xhjc.springdemo.config;

import com.xhjc.springdemo.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author xhj
 *
 *  @Description @Configuration：指明当前类是一个配置类；就是来代替之前的Spring配置文件
 *
 * @Date 2019-05-25 16:19
 **/
@Configuration
public class MyConfig {

    @Bean
    public HelloService helloService(){
        System.out.println("配置类给容器添加了HelloService组件");
        return new HelloService();
    }
}
