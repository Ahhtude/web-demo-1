package org.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"org.demo.controllers",
        "org.demo.components",
                                "org.demo.dao"})
@Import({DataBaseConfiguration.class})

public class ApplicationConfig {

}
