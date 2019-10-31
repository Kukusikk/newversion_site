package com.example.NedoAvito;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class NedoAvitoApplication implements ApplicationRunner {


	public static void main(String[] args) {

		SpringApplication.run(NedoAvitoApplication.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {


		System.out.print("8");




	}
}
