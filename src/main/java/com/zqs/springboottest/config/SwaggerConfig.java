package com.zqs.springboottest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @program: springboottest
 * @description: swagger配置类
 * @author: Mr.Zhang
 * @create: 2020-09-16 18:13
 **/
@Configuration
@EnableSwagger2 //开启swagger
public class SwaggerConfig {
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("小张一号");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("小张二号");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("小张三号");
    }
    //配置Swagger的Docket的bean实例
    @Bean
    public Docket docket()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("顾沉舟")
                .select()
                /*RequestHandlerSelectors:配置要扫描接口的方式
                 *basePackage 指定要扫描的包
                 *   any()  扫描全部
                 *   none()  都不扫描
                 *   withClassAnnotation() 扫描类上的注解 通过反射的方式
                 *   withMethodAnnotation() 扫描方法上的注解
                 **/
                .apis(RequestHandlerSelectors.basePackage("com.zqs.springboottest"))
                //过滤什么路径 paths()
                //   ant("/zqs/**")不过滤zqs包下的所有包
                //.paths(PathSelectors.ant("/zqs/**"))
                .build();
    }

    //配置swagger信息apiInfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("张淇舒", "http://sinkingboat.cn", "2540074917@qq.com");
        return new ApiInfo(
                "搬砖小张的swagger文档",
                "SpringBoot+vue前后端分离项目",
                "v1.0",
                "http://sinkingboat.cn",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }



}
