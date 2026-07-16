package br.com.limmazk.restaurante_api.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Restaurant API")
                        .description("REST API para gerenciamento de clientes, pratos, pedidos, pagamentos e entregas.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Arthur Lima")
                                .email("arthurlimma2008@gmail.com")
                                .url("https://github.com/SEU-USUARIO"))
                        .license(new License()
                                .name("MIT License")))
                .externalDocs(new ExternalDocumentation()
                        .description("Repositório no GitHub")
                        .url("https://github.com/limmazk/api-restaurante.git"));
    }
}