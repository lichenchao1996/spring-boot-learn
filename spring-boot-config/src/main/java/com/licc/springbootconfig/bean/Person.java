package com.licc.springbootconfig.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 将配置文件中配置的每一个属性的值,映射到这个组件中
 *
 * @ConfigurationProperties:告诉SpringBoot将本类中的所有属性和配置文件中相关配置进行绑定 prefix = "person":配置文件中哪个下面的所有属性进行一一映射
 * 只有这个组件是容器中的组件,才能使用容器提供的@ConfigurationProperties功能
 * @ConfigurationProperties(prefix = "person") 默认从全局配置(application.properties/yml)中获取person中的值
 * 优先级: application.properties > application.yml > 自定义的proterties文件
 */

@Component

//加载指定(非application.properties/yml)的配置文件,可以数组形式获取多个
//注意:如果application.properties/yml中有相同的值,会优先拿application中的
//@PropertySource(value = {"classpath:person.properties"})

/*@ConfigurationProperties() 编写了一个javaBean来和配置文件进行映射
功能:批量注入配置文件中的属性
松散绑定(松散语法):支持 (个人感觉他支持是因为yml语法支持,跟@value不支持并无关系,因为@value拿的是yml中的属性名)
SpEL:不支持 (yml里不能使用SpringEl表达式)
JSR303数据校验:支持
最大不同:复杂类型封装:支持*/
@ConfigurationProperties(prefix = "person")
//java bean中的属性需要校验
@Validated
public class Person {
    /**
     * <bean class="Person">
     * <property name="lastName" value="字面量/${key}从环境变量 配置文件中获取值/#{SpringEL表达式}"></property>
     * </bean>
     * 等同于 @Value()
     */
/*@Value() 在某个业务逻辑中需要获取一下配置文件中的某项值
功能:一个一个指定
松散绑定(松散语法):不支持
SpEl:支持 (@Value()里可以使用SpEL表达式)
JSR303数据校验:不支持 (typemismatch)
最大不同:复杂类型封装:不支持*/
    //配置文件中的(properties跟yml文件中都有的相同的属性名会拿properties中的)
    //@Value("${person.last-name}")
    //校验注入的lastName是一个Email
    //@Email
    private String lastName;
    //SpringEl表达式
    //@Value("#{11*2}")
    private Integer age;
    //字面值(布尔)
    //@Value("true")
    private Boolean boss;
    private Date birth;
    //@Value("${person.maps}")
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
