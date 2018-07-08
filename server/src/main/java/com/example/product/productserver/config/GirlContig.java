package com.example.product.productserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Auther: tkn
 * @Date: 2018/7/8 18:32
 * @Description:
 */
@Data
@ConfigurationProperties("girl")
@Component
@RefreshScope
public class GirlContig {

    private String name;
    private String age;
}
