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
import com.example.NedoAvito.conteiner.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static com.example.NedoAvito.conteiner.SortingPrinciple.age;

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
		Tag tag0=tagService.createTag("root", null);
		Tag tag1=tagService.createTag("property", tag0);
		Tag tag2=tagService.createTag("transport", tag0);
		Tag tag3=tagService.createTag("houses", tag1);
		Tag tag4=tagService.createTag("apartments", tag1);
		Tag tag5=tagService.createTag("4 wheels", tag2);
		Tag tag6=tagService.createTag("2 wheels", tag2);
		Tag tag7=tagService.createTag("with yard", tag3);
		Tag tag8=tagService.createTag("without yard", tag3);
		Tag tag9=tagService.createTag("1 rooms", tag4);
		Tag tag10=tagService.createTag("2 rooms", tag4);
		Tag tag11=tagService.createTag("3 rooms", tag4);
		Tag tag12=tagService.createTag("4 rooms", tag4);
		Tag tag13=tagService.createTag("car", tag5);
		Tag tag14=tagService.createTag("bicycles", tag6);
		Tag tag15=tagService.createTag("motorcycles", tag6);
		Tag tag16=tagService.createTag("scooters", tag6);
		Tag tag17=tagService.createTag("manual", tag13);
		Tag tag18=tagService.createTag("automatic", tag13);


		User user0=new User("login", "phone", "photo");
		userService.save(user0);
		Advertisement advertisement1=new Advertisement(user0, 578,"AAA",tag8);

		advertisementServis.saveAdvertisement(advertisement1 );

		tag8.getAdvertisements().add(advertisement1);
		tagService.update(tag8);

		user0.getAdvertisements().add(advertisement1);
		userService.save(user0);







//		Set<Tag> result=tagService.findAllChildTagsforone(tag0);
//		Advertisement a=new Advertisement(userService.save(new User()));
//		Tag t=tagService.save(new Tag());
//		a.setTag(t);
//		advertisementServis.save(a);




		Set<UUID> result=new HashSet<>();
		UUID uuid = tag0.getIdtag();
//		UUID uuid= UUID.nameUUIDFromBytes("4120b90b-1924-430b-9208-1e9f9909ab42".getBytes("UTF-8"));
		result.add(uuid);
		Filter f=new Filter(false,3234, 300, 1, "AAA", result);
//
		List<Advertisement>a= advertisementServis.AdvertisementsByFiltersearch(f);
		System.out.print("-------------------------------------------------------------8--------------------------");


		//???????????????????????????????????????????????????????????????????????????????????????????????????????????????????

		User user1=new User("login2", "phone", "photo");
		userService.save(user1);
		Advertisement advertisement2=new Advertisement(user1, 578,"AAA",tag7);
//		user0.getAdvertisements().add(advertisement1);

		advertisementServis.saveAdvertisement(advertisement2 );

		tag7.getAdvertisements().add(advertisement2);
		tagService.update(tag7);

		user1.getAdvertisements().add(advertisement2);
		userService.save(user1);


//nikita
		Tag[] tags = new Tag[] {tag6,tag9,tag10,tag11,tag12,tag13,tag14,tag15,tag16,tag17,tag18};
		for(int i = 0; i < 6; ++i) {
			User iuser = new User("loginaaa" + Integer.toString(i), "phone", "photo");
			userService.save(iuser);
			Advertisement iadvertisement = new Advertisement(iuser, 578, "AAA", tags[i]);
//		user0.getAdvertisements().add(advertisement1);

			advertisementServis.saveAdvertisement(iadvertisement);

			tags[i].getAdvertisements().add(iadvertisement);
			tagService.update(tags[i]);

			iuser.getAdvertisements().add(iadvertisement);
			userService.save(iuser);
		}


//		?????????????????????????????????????????????????????????????????????????????????????????????????????



	}
}
