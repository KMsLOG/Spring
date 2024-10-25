package com.ssafy.hw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	  @Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("SSAFY 사용자관리 API")
	              .description("과제에서 사용되는 RestApi에 대한 문서를 제공한다")
	              .version("v0.0.1")
	              .license(new License().name("SSAFY   Website").url("http://springdoc.org")))
	              .externalDocs(new ExternalDocumentation()
	              .description("Send email to SSAFY")
	              .url("https://springshop.wiki.github.org/docs"));
	  }


}
