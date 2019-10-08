package com.example.NedoAvito;


import com.example.NedoAvito.entity.Advertisement;
import com.example.NedoAvito.entity.User;
import com.example.NedoAvito.repository.AdvertisementRepository;
import com.example.NedoAvito.repository.UserRepository;
import com.example.NedoAvito.servis.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@SpringBootApplication
public class NedoAvitoApplication implements ApplicationRunner {
    @Autowired
	UserRepository rec;
	@Autowired
	UserService userservice;
	public static void main(String[] args) {

		SpringApplication.run(NedoAvitoApplication.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		rec.save(new User("ee","ddd", "sss",null, null));
//		List<User> b=rec.findAll();
		UUID i=UUID.fromString("6151d589-a88b-4dd7-a20a-cea162cdd547");
		UUID i2=UUID.fromString("6151d589-a88b-4dd7-a20a-cea162cdd544");



		Advertisement a=userservice.findByLoginAdvertisementById("ee",i);
		Advertisement b=userservice.findByLoginAdvertisementById("ee", i2);



	}
}
