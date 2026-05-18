package br.com.ifba.curso.util;

import br.com.ifba.curso.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringContext {
    private static ApplicationContext context;

    public static ApplicationContext getContext() {
        if (context == null) {
            context = new AnnotationConfigApplicationContext(AppConfig.class);
        }
        return context;
    }
}