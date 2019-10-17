package com.example.NedoAvito.dao.Advertisement;


import com.example.NedoAvito.entity.Advertisement;
import com.example.NedoAvito.entity.Tag;
import com.example.NedoAvito.entity.User;
import com.example.NedoAvito.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
@Component
public class AdvertisementDaoImpl implements AdvertisementDao {
    @Autowired
    private AdvertisementRepository advertisementRepository;
    //показать все объявления
    public List<Advertisement> findAll(){return advertisementRepository.findAll();}
    //сохранить объявление
    public Advertisement save(Advertisement advertisement){return advertisementRepository.save(advertisement);}
    //показать объявление по его id
    public Optional<Advertisement> findById(UUID id){return  advertisementRepository.findById(id);}
    //удаление объявления с заданным id
    public void deleteById(UUID id){advertisementRepository.deleteById(id);}
    //удаление объявления
    public void delete(Advertisement advertisement){advertisementRepository.delete(advertisement);}
    //удаление всех постов юзера
    public void deleteByUser(User user){advertisementRepository.deleteByUser(user);}
    // удаление объявление с заданным id относительно юзера
    public void deleteByUserAndIdForUser(User user, Integer idForUser){advertisementRepository.deleteByUserAndIdForUser(user, idForUser);}
    //выдать все объявления сортированные по количеству просмотров
    public List<Advertisement> findAllByOrderByNumberviewsDesc(){return advertisementRepository.findAllByOrderByNumberviewsDesc();}
    //выдать все объявления по новизне(от самых новых)
    public List<Advertisement> findAllByOrderByDateAsc(){return advertisementRepository.findAllByOrderByDateAsc();}
    //выдать объявления по цене(от самых дешевых)
    public List<Advertisement> findAllByOrderByPriceAsc(){return advertisementRepository.findAllByOrderByPriceAsc();}



    public List<Advertisement> findByFilterByDate(String name, int topprice, int lowprice, Set<Tag> tags){return advertisementRepository.findByFilterByDate( name,  topprice,  lowprice,tags);}
    public List<Advertisement> findByFilterByNumberviews( String name, int topprice, int lowprice, Set<Tag> tags){return advertisementRepository.findByFilterByNumberviews( name,  topprice,  lowprice,tags);}
    public List<Advertisement> findByFilterByPrice( String name, int topprice, int lowprice, Set<Tag> tags){return advertisementRepository.findByFilterByPrice( name,  topprice,  lowprice,tags);}

}
