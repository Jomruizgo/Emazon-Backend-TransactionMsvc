package com.emazon.msvc_transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsvcTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcTransactionApplication.class, args);
	}

}
