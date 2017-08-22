package com.xzq.firstspringboot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Firstspringboot2Application {

	@Autowired
	private  AuthorSettings authorSettings;

	@RequestMapping("/")
	public String index(){

		return "hello Spring boot"+authorSettings.getName()+"  "+authorSettings.getAge();
	}
	public static void main(String[] args) {
		SpringApplication.run(Firstspringboot2Application.class, args);
	}
}
