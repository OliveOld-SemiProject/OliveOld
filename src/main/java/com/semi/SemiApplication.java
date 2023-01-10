package com.semi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

@SpringBootApplication(exclude={MultipartAutoConfiguration.class}) //파일 업로드를 위해 자동 구성 제외

public class SemiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SemiApplication.class, args);
	}
}
