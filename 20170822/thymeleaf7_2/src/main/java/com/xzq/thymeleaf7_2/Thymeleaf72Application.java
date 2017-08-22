package com.xzq.thymeleaf7_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@SpringBootApplication
public class Thymeleaf72Application {

	@RequestMapping("/")
	public  String index(Model model){

		Person single=new Person("AA",11);

		List<Person> people=new ArrayList<Person>();
		Person p1=new Person("XX",11);
		Person p2=new Person("YY",22);
		Person p3=new Person("ZZ",33);
		people.add(p1);
		people.add(p2);
		people.add(p3);
		model.addAttribute("SinglePerson",single);
		model.addAttribute("people",people);

		return "index";


	}

	public static void main(String[] args) {
		SpringApplication.run(Thymeleaf72Application.class, args);
	}
}
