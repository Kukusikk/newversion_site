package com.example.NedoAvito;

import com.example.NedoAvito.entity.Advertisement;
import com.example.NedoAvito.entity.User;
import com.example.NedoAvito.repository.AdvertisementRepository;
import com.example.NedoAvito.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NedoAvitoApplication implements ApplicationRunner {
    @Autowired
	UserRepository rec;
	public static void main(String[] args) {

		SpringApplication.run(NedoAvitoApplication.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		User a=new User("k", "ko", "gggggu");

	//	rec.save(a);



	}
}
