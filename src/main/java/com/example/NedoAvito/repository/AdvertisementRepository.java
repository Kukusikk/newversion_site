package com.example.NedoAvito.repository;

import com.example.NedoAvito.entity.Advertisement;
import com.example.NedoAvito.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public  interface AdvertisementRepository extends CrudRepository<Advertisement, UUID> {
    //показать все объявления
    List<Advertisement> findAll();
    //сохранить объявление
    Advertisement save(Advertisement advertisement);
    //показать объявление по его id
    Optional<Advertisement> findById(UUID id);
    //удаление объявления с заданным id
    void deleteById(UUID id);
    //удаление объявления
    void delete(Advertisement advertisement);
    //удаление всех постов юзера
    void deleteByUser(User user);
    // удаление объявление с заданным id относительно юзера
    void deleteByUserAndIdForUser(User user, Integer idForUser);
  //выдать все объявления сортированные по количеству просмотров
    List<Advertisement> findAllByOrderByNumberviewsDesc();
    //выдать все объявления по новизне(от самых новых)
    List<Advertisement> findAllByOrderByDateAsc();
    //выдать объявления по цене(от самых дешевых)
    List<Advertisement> findAllByOrderByPriceAsc();



}

