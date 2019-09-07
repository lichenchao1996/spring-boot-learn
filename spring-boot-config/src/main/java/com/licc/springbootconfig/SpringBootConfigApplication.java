package com.licc.springbootconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/*导入Spring的配置文件,让配置文件里面的内容生效 (Spring Boot不推荐这样给容器中加组件,推荐使用全注解的方式)
Spring Boot里没有Spring的配置文件,自己编写的配置文件也不能自动识别
想让Spring的配置文件生效加载进来,使用@ImportResource标注在一个配置类上*/
//@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
public class SpringBootConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConfigApplication.class, args);
    }

}
