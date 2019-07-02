package com.xhjc.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author xhj
 * @Description //TODO
 * @Date 2019-07-01 15:05
 **/
@ConfigurationProperties(prefix = "xhjc.hello")
public class HelloProperties {
    private String prefix;
    private String sufix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSufix() {
        return sufix;
    }

    public void setSufix(String sufix) {
        this.sufix = sufix;
    }
}
