package com.skill;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
@EnableSwagger2
public class SkillTestAppApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(SkillTestAppApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration()
	{
		return new Docket(DocumentationType.SWAGGER_2).select()
				// .paths(PathSelectors.ant("/"+profile+"/api/*"))
				.apis(RequestHandlerSelectors.any()).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo()
	{
		return new ApiInfo("Job portal", "Application for job searching", "1.0", "Free",
				new Contact("Ebin", "", "ebinms@gmail.com"), "Ebin", "Nil", new ArrayList<>());
	}
}
