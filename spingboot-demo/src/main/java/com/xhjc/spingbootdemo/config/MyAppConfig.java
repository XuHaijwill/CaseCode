package com.xhjc.spingbootdemo.config;

import com.xhjc.spingbootdemo.component.MyLocalResolver;
import com.xhjc.spingbootdemo.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author xhj
 * @Description //TODO
 * @Date 2019-06-27 15:50
 **/
@Configuration
public class MyAppConfig extends WebMvcConfigurerAdapter{
    //将方法的返回值添加到容器中；容器这个组件id就是方法名
    @Bean
    public HelloService helloService01(){
        System.out.println("配置类给容器添加了HelloService组件");
        return new HelloService();
    }

    @Bean //註冊到容器去
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("Dashboard");
            }
            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源 css js 已经做好了静态资源映射
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
//                        excludePathPatterns("/index.html","/","/user/login");
            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
