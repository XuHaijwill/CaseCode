package com.xhjc.spingbootdemo.config;

import com.xhjc.spingbootdemo.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author xhj
 * @Description //TODO
 * @Date 2019-06-27 15:50
 **/
@Configuration
public class MyAppConfig {
    //将方法的返回值添加到容器中；容器这个组件id就是方法名
    @Bean
    public HelloService helloService01(){
        System.out.println("配置类给容器添加了HelloService组件");
        return new HelloService();
    }
}
