package com.porto.salv.configs;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.*;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        Server server = new Server();
        server.setUrl("/sboot-jenkins");
        return new OpenAPI().addSecurityItem(new SecurityRequirement().addList("oauth")).servers(List.of(server)).components(getComponents());
    }

    private Components getComponents() {
        SecurityScheme oauth = new SecurityScheme().type(SecurityScheme.Type.OAUTH2);
        SecurityScheme token = new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT");

        Map<String, SecurityScheme> securitySchemes = new HashMap<>();
        securitySchemes.put("oauth", oauth);
        securitySchemes.put("token", token);
        return new Components().securitySchemes(securitySchemes);
    }
}