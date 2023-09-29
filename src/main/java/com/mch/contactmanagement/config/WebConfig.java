package com.mch.contactmanagement.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "API Contact Management",
                        email = "marwen.chebbi@gmail.com",
                        url = "http://monurl"
                ),
                description = "${application-description}",
                title = "API Contact Management",
                version = "${application-version}"
        ),
        servers = {
                @Server(
                        description = "local ENV",
                        url = "http://localhost:8081/api-contact/"
                ),
                @Server(
                        description = "dev ENV",
                        url = "https://dev.api-contact/api-contact/"
                )
        }
)
public class WebConfig {
}
