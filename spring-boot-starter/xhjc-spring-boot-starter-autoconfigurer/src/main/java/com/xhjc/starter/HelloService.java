package com.xhjc.starter;

/**
 * @Author xhj
 * @Description //TODO
 * @Date 2019-07-01 15:07
 **/
public class HelloService {

    HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHello(String name){
        return helloProperties.getPrefix() + "-" + name + "-" + helloProperties.getSufix();
    }
}
