package it.core.facilitator.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
//@EntityScan(basePackages = { "it.core.facilitator.boot.entity" })
//@EnableJpaRepositories(basePackages = {"it.core.facilitator.boot.repository"})
//@ComponentScan(basePackages = {"it.core.facilitator.boot.controller", "it.core.facilitator.boot.service"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
//@EnableTransactionManagement  
public class BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
		System.out.println("********************************************************************************************");
		System.out.println("*****************************   FACILITATOR   **********************************************");
		System.out.println("********************************************************************************************");
	}

}
