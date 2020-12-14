package com.bucket.swagger.configuration;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wei.wang
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfiguration {
    @Value("${spring.swagger.title}")
    private String title;
    @Value("${spring.swagger.description}")
    private String description;
    @Value("${spring.swagger.contact-name}")
    private String contactName;
    @Value("${spring.swagger.contact-email}")
    private String email;
    @Value("${spring.swagger.version}")
    private String version;
    @Value("${spring.swagger.license-url}")
    private String licenseUrl;
    @Value("${spring.swagger.license}")
    private String license;
    @Value("${spring.swagger.base-package}")
    private String basePackage;

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("2.X版本")
                .select()
                //这里指定Controller扫描包路径(项目路径也行)
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact(contactName, " http://127.0.0.1:8080/doc.html#/home", email);
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl("https://www.baidu.com")
                .contact(contact)
                .license(license)
                .licenseUrl(licenseUrl)
                .version(version)
                .build();
    }
}
