package com.mly.demodev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration//让spring加载此类
@EnableSwagger2//启用swagger类
public class SwaggerConfig{
    @Bean
    public Docket controllerApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(true)
                .forCodeGeneration(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mly.demodev.action"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API文档")
                .description("Api文档规范")
                .termsOfServiceUrl("http://路径.com")
                .version("2.0")
                .build();
    }
}
