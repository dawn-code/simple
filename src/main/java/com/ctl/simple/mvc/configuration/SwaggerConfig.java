package com.ctl.simple.mvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Administrator
 */
@Configuration
public class SwaggerConfig {

    /**
     * swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     * @return Docket
     */
    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //扫描需要生成文档的包
                .apis(RequestHandlerSelectors.basePackage("com.ctl.simple"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建api文档的详细信息函数,注意这里的注解引用的是哪个
     * @return ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //文档说明页面标题
                .title("Simple API")
                //文档版本说明
                .version("v1.0")
                //创建人信息
                .contact(new Contact("JARVIS", "http://127.0.0.1:8080/swagger-ui.html", ""))
                .build();
    }
}
