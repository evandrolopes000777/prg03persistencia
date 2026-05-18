package br.com.ifba.curso.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "br.com.ifba") // procura os beans em todas as pastas
public class AppConfig {
}