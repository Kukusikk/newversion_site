package com.example.NedoAvito.repository;

import com.example.NedoAvito.entity.Advertisement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public  interface AdvertisementRepository extends CrudRepository<Advertisement, Integer> {
    //показать все объявления
    List<Advertisement> findAll();
    //сохранить объявление
    Advertisement save(Advertisement advertisement);
    //показать объявление по его id
    Optional<Advertisement> findById(Integer id);
    //удаление объявления с заданным id
    void deleteById(Integer integer);
    //удаление объявления
    void delete(Advertisement advertisement);



    //удаление всех постов юзера
    //void deleteByUser(User user);
    // удаление заданного поста заданного юзера
  //  void deleteByidForUserAndUser();
  //  Set<Record> findByUser(User user);


}

