Springfox spring starter
1. MVN: 
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
3. 	http://localhost:8081/swagger-ui.html
	http://localhost:8081/v2/api-docs
***************************************************************************************************
package com.spring.contractvb.Utils;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
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
*********************************************************************************
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/module")
@Api(
    tags = {"Contract"}, 
    description = "Contract based REST services Application", 
    // value = "HRMS Module", 
    produces = "application/json"
    )
*********************************************************************************
@ApiOperation(value = "Returns all list of users.", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<User>> getAllUsers() {

        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }
*********************************************************************************
weglogic.xml:-
<?xml version="1.0" encoding="UTF-8"?>
<wls:weblogic-web-app
        xmlns:wls="http://xmlns.oracle.com/weblogic/weblogic-web-app"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://xmlns.oracle.com/weblogic/weblogic-web-app
        http://xmlns.oracle.com/weblogic/weblogic-web-app/1.4/weblogic-web-app.xsd">
     <wls:context-root>/apps</wls:context-root>
    <wls:container-descriptor>
        <wls:prefer-application-packages>
            <package-name>org.springframework.*</package-name>
            <!-- <package-name>org.hibernate.*</package-name> -->
            <!-- <package-name>javax.validation.*</package-name> -->
            <!-- <package-name>javax.validation.spi.*</package-name> -->
            <!-- <package-name>org.slf4j.*</package-name> -->
            <package-name>com.fasterxml.jackson</package-name>
        </wls:prefer-application-packages>
    </wls:container-descriptor>
 </wls:weblogic-web-app>
 *********************************************************************************
