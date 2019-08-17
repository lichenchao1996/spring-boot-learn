package com.licc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 来标注一个主程序类,说明这是一个Spring Boot应用
 */

/**
 * @Target({ElementType.TYPE})
 * @Retention(RetentionPolicy.RUNTIME)
 * @Documented
 * @Inherited
 * @SpringBootConfiguration: Spring Boot的配置类,标注在某个类上,表示是Spring Boot的一个配置类
 *  (@Configuration: 配置类上来标注这个注解(配置类----配置文件;配置类也是容器中的一个组件;@Component))
 * @EnableAutoConfiguration: 开启自动配置功能,以前需要配置的东西,Spring Boot帮我们自动配置,该注解告诉SPring Boot开启自动配置功能
 *  (@AutoConfigurationPackage: 自动配置包,将主配置类(@SpringBootApplication标注的类)的所在包及其下的作于子包里的所有塑件扫描到Spring容器
 *    (@Import(AutoConfigurationPackages.Registrar.class): Spring底层注解,给容器中导入一个组件;导入的组件由AutoConfigurationPackages.Registrar.class决定))
 *  (@Import(EnableAutoConfigurationImportSelector.class): 给容器添加一个组件
 *    (EnableAutoConfigurationImportSelector: 导入哪些组件的选择器;将所有需要导入的组件以全类名的方式返回,这些组件就会被添加到容器中,会给容器中导入非常多的自动配置类(xxxAutoConfiguration),就是给容器中导入这个场景需要的所有组件,并配置好这些组件;有了自动配置类,免去了我们手动编写配置注入功能组件等工作
 *      (AutoConfigurationImportSelector.getCandidateConfigurations() -> SpringFactoriesLoader.loadFactoryNames(EnableAutoConfiguration.class, classLoader): Spring Boot在启动的时候从类路径下的META-INF/spring.factories中获取EnableAutoConfiguration指定的值,将这些值作为自动配置类导入到容器中,自动配置类就生效,进行自动配置工作
 *      以前我们需要自己配置的东西,自动配置类都帮我们配置了)))
 * @ComponentScan(
 *     excludeFilters = {@Filter(
 *     type = FilterType.CUSTOM,
 *     classes = {TypeExcludeFilter.class}
 * ), @Filter(
 *     type = FilterType.CUSTOM,
 *     classes = {AutoConfigurationExcludeFilter.class}
 * )}
 * )
 */
@SpringBootApplication
public class HelloWorldMainApplication {
    public static void main(String[] args) {
        //启动Spring应用
        //run方法需要传入一个被@SpringBootApplication标注的类
        SpringApplication.run(HelloWorldMainApplication.class, args);
    }
}
