package com.kimlog;

import com.kimlog.api.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(AppConfig.class)
@SpringBootApplication
public class KimlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(KimlogApplication.class, args);
	}

}
