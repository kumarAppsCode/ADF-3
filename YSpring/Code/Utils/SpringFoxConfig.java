Springfox spring starter
1. MVN: springfox-boot-starter(Parent)
<!-- https://mvnrepository.com/artifact/io.springfox/springfox-boot-starter -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
Child:
	<dependency>
		<groupId>io.springfox</groupId>
		<artifactId>springfox-swagger2</artifactId>
		<version>2.9.2</version>
	</dependency>
--------------------------------------------------------------------
	<dependency>
		<groupId>io.springfox</groupId>
		<artifactId>springfox-swagger-ui</artifactId>
		<version>2.9.2</version>
	</dependency>
--------------------------------------------------------------------
2. Main application : @EnableSwagger2
3. http://localhost:8081/swagger-ui/
***************************************************************************************************
package com.sample.contract.Utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import io.swagger.annotations.Api;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.builders.ApiInfoBuilder;

/**
 * Swagger Configuration
 * @author Dinesh
 *
 */
@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    // http://localhost:8081/swagger-ui/

    // import io.swagger.annotations.Api;
    // @Api(tags = {"Employees"}, description = "Employee based services for Ooredoo HRMS Mobile Application", 
    // value = "HRMS Module", produces = "application/json")

    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .apiInfo(metaData())
          .select()                      
          .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))              
          .paths(PathSelectors.any())                          
          .build();                                           
    }

    @Bean
    public ApiInfo metaData() {
        final ApiInfoBuilder builder = new ApiInfoBuilder();
        builder.title("TEST API").version("1.0")
        .description("List of all the APIs of TEST Mobile App");
        return builder.build();
        }
}


*********
In main class
@EnableSwagger2
import springfox.documentation.swagger2.annotations.EnableSwagger2;
