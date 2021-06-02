package com.vdcompany.adminSmartbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AdminSmartboxApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AdminSmartboxApplication.class);
	}

	public static void main(String[] args) { 
		//SpringApplication.run(AdminSmartboxApplication.class, args);
		ApplicationContext ctx = SpringApplication.run(AdminSmartboxApplication.class, args);
	}

}
