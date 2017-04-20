package com.esportbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
//启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
//使用注解 @EnableTransactionManagement 开启事务支持后，然后在访问数据库的Service方法上添加注解 @Transactional 便可。
//关于事务管理器，不管是JPA还是JDBC等都实现自接口 PlatformTransactionManager
//如果你添加的是 spring-boot-starter-jdbc 依赖，框架会默认注入 DataSourceTransactionManager 实例。
//如果你添加的是 spring-boot-starter-data-jpa 依赖，框架会默认注入 JpaTransactionManager 实例.
@SpringBootApplication
//等价@Configuration, @EnableAutoConfiguration, @ComponentScan
//@Configuration：
//提到@Configuration就要提到他的搭档@Bean。
//使用这两个注解就可以创建一个简单的spring配置类，可以用来替代相应的xml配置文件。
//@Configuration的注解类标识这个类可以使用Spring IoC容器作为bean定义的来源。
//@Bean注解告诉Spring，一个带有@Bean的注解方法将返回一个对象，该对象应该被注册为在Spring应用程序上下文中的bean。

//@EnableAutoConfiguration：
//能够自动配置spring的上下文，试图猜测和配置你想要的bean类，通常会自动根据你的类路径和你的bean定义自动配置。

//@ComponentScan：
//会自动扫描指定包下的全部标有@Component的类，并注册成bean，
//当然包括@Component下的子注解@Service,@Repository,@Controller。
public class EsportBookApplication {

	@Bean
	public Object testBean(PlatformTransactionManager platformTransactionManager){
		System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
		return new Object();
	}
	public static void main(String[] args) {
		SpringApplication.run(EsportBookApplication.class, args);
	}
}
