package MVC.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ServletComponentScan
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		//test branch1
		//test 2
		//test 3 -> commit2
		SpringApplication.run(ServletApplication.class, args);
	}

	/*  스프링부트가 자동으로 해주는 설정정	@Bean
	InternalResourceViewResolver internalResourceViewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/","jsp");
	}
	 */

}
