package com.donler.gym.docs;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Created by jason on 4/14/16.
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {


  @Bean
  public Docket userApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .paths(userPath())
        .build();
  }

  private ApiInfo apiInfo() {

    return new ApiInfoBuilder()
        .title("Donler gym API")
        .description("donler's gym server api docs")
        .termsOfServiceUrl("https://github.com/leftjs/gym-api")
        .contact(new Contact("leftjs", "https://github.com/leftjs", "lefttjs@gmail.com"))
        .license("MIT")
        .licenseUrl("http://opensource.org/licenses/MIT")
        .version("1.0")
        .build();
  }


  private Predicate<String> userPath() {
    return PathSelectors.regex("/user/.*");
  }

}
