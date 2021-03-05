package com.module.admin_module.Utils;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

// import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
// WebMvcConfigurerAdapter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        
        PageableHandlerMethodArgumentResolver pageResolver=new PageableHandlerMethodArgumentResolver();
        
        //parameter for page
        pageResolver.setPageParameterName("page-number");
        //parameter for page size
        pageResolver.setSizeParameterName("page-size");

        // PageRequest.of(1, 6);
        pageResolver.setFallbackPageable(PageRequest.of(1, 6));

        // Pageable pa= new PageRequest(0, 5);
        // pageResolver.setFallbackPageable(pa);
        //default 1 will come other wise from 0
        pageResolver.setOneIndexedParameters(true);


        resolvers.add(pageResolver);

        // TODO Auto-generated method stub
        // WebMvcConfigurer.super.addArgumentResolvers(resolvers);
    }

    

}
