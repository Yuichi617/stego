package com.movies.stegobe.app.common

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class SwaggerConfig {
    @Bean
    fun api(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.movies.stegobe.app.internal_v1.controller"))
            .paths(PathSelectors.any())
            .build()
            // デフォルトのレスポンスを非表示に
            .useDefaultResponseMessages(false)
            .apiInfo(apiInfo())
    }

    fun apiInfo(): ApiInfo? {
        val apiInfo = ApiInfoBuilder()
        return apiInfo
            .title("Movies API")
            .description("Description of Movies API.")
            .version("1.0.0")
            .contact(Contact("Yuichi Sugiyama", "https://www.yuichi-sugiyama.com", "ozwald176@gmail.com"))
            .license("The MIT License")
            .licenseUrl("https://opensource.org/licenses/mit-license.php")
            .build()
    }
}
