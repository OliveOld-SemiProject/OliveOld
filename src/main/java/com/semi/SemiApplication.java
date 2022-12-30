package com.semi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SemiApplication {

	public static void main(String[] args) {
		System.out.println("To 업데이트 했습니다.");
		System.out.println("메인 업데이트 했습니다.");
		SpringApplication.run(SemiApplication.class, args);
	}
}
