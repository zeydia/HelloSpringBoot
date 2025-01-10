package sn.edu.ugb.ipsl.HelloSpringBoot.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI getOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                        .title("Hello SpringBoot")
                        .version("1.0")
                        .description("Example API description")
                        .contact(
                                new Contact()
                                .email("douseydiallo2002@gmail.com")
                        )
                );
    }


}
