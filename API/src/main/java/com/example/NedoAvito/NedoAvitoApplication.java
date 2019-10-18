package com.example.NedoAvito;


import com.example.NedoAvito.entity.Advertisement;
import com.example.NedoAvito.entity.Tag;
import com.example.NedoAvito.entity.User;
import com.example.NedoAvito.servise.AdvertisementServise;
import com.example.NedoAvito.servise.TagService;
import com.example.NedoAvito.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NedoAvitoApplication implements ApplicationRunner {
    @Autowired
	TagService tagService;
    @Autowired
	AdvertisementServise advertisementServis;
    @Autowired
	UserService userService;

	public static void main(String[] args) {

		SpringApplication.run(NedoAvitoApplication.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//создадим тэг
//		Tag tag0=tagService.createTag("root", null);
//		Tag tag1=tagService.createTag("property", tag0);
//		Tag tag2=tagService.createTag("transport", tag0);
//		Tag tag3=tagService.createTag("houses", tag1);
//		Tag tag4=tagService.createTag("apartments", tag1);
//		Tag tag5=tagService.createTag("4 wheels", tag2);
//		Tag tag6=tagService.createTag("2 wheels", tag2);
//		Tag tag7=tagService.createTag("with yard", tag3);
//		Tag tag8=tagService.createTag("without yard", tag3);
//		Tag tag9=tagService.createTag("1 rooms", tag4);
//		Tag tag10=tagService.createTag("2 rooms", tag4);
//		Tag tag11=tagService.createTag("3 rooms", tag4);
//		Tag tag12=tagService.createTag("4 rooms", tag4);
//		Tag tag13=tagService.createTag("car", tag5);
//		Tag tag14=tagService.createTag("bicycles", tag6);
//		Tag tag15=tagService.createTag("motorcycles", tag6);
//		Tag tag16=tagService.createTag("scooters", tag6);
//		Tag tag17=tagService.createTag("manual", tag13);
//		Tag tag18=tagService.createTag("automatic", tag13);
//
//
//		Set<Tag> result=tagService.findAllChildTagsforone(tag0);
		Advertisement a=new Advertisement(userService.save(new User()));
//		Tag t=tagService.save(new Tag());
//		a.setTag(t);
//		advertisementServis.save(a);

		System.out.print("8");








	}
}
