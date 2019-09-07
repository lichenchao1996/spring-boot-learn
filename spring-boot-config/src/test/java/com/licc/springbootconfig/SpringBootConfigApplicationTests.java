package com.licc.springbootconfig;

import com.licc.springbootconfig.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot单元测试
 * <p>
 * 可以在测试期间很方便的类似编码一样进行自动注入到容器的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootConfigApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    public void testHelloService() {
        //判断是否包含一个bean
        boolean flag = ioc.containsBean("helloService");
        System.out.println(flag);
    }

    @Test
    public void contextLoads() {
        System.out.println(person);
    }

}
