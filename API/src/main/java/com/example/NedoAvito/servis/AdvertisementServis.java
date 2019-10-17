package com.example.NedoAvito.servis;

import com.example.NedoAvito.conteiner.Filter;
import com.example.NedoAvito.conteiner.SortingPrinciple;
import com.example.NedoAvito.dao.Advertisement.AdvertisementDaoImpl;
import com.example.NedoAvito.entity.Advertisement;
import com.example.NedoAvito.entity.Tag;
import com.example.NedoAvito.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdvertisementServis {
    @Autowired
    AdvertisementDaoImpl advertisementdao;
    @Autowired
    TagService tagService;

    //сохранить объявление
    public Advertisement save(Advertisement advertisement) {
        return advertisementdao.save(advertisement);
    }

    // удалить объявление по ее id
    public void deleteById(UUID id) {
        advertisementdao.deleteById(id);
    }

    //показать топ  самых популярных 10 объявление
    public List<Advertisement> findAllByOrderByNumberviewsDesc() {
        return advertisementdao.findAllByOrderByNumberviewsDesc().stream().limit(10).collect(Collectors.toList());
    }

    //выдать конкретное объявление по ее id
    public Optional<Advertisement> findById(UUID id) {
        return advertisementdao.findById(id);
    }

    // выдать все объявление по заданному в поисковике фильтру
    public List<Advertisement> filtersearch(Filter filter) {
        List<Advertisement> advertisements = new ArrayList<>();

        switch (filter.getSortingprinciple()) {
            case popularity:
                //выдача с ценой+имя+наличие в тэге+сортировка по популярности
                advertisements = advertisementdao.findByFilterByNumberviews(filter.getName(), filter.getTopprice(), filter.getLowerprice(), tagService.findAllChildTagsforSet(filter.getTags(), new HashSet<>()));
                break;
            case age:
                //выдача с ценой+имя+наличие в тэге+сортировка по дате
                advertisements = advertisementdao.findByFilterByDate(filter.getName(), filter.getTopprice(), filter.getLowerprice(), tagService.findAllChildTagsforSet(filter.getTags(), new HashSet<>()));
                break;
            case price:
                //выдача c ценой+имя+наличие в тэге+сортировка по цене
                advertisements = advertisementdao.findByFilterByPrice(filter.getName(), filter.getTopprice(), filter.getLowerprice(), tagService.findAllChildTagsforSet(filter.getTags(), new HashSet<>()));
                break;
        }

        //проверяем наличие слов в описании
        for (Advertisement advertisement : advertisements) {
            for (String world : filter.getFordiscription()) {
                //идем по слову в описании и находим его в строке описания товара
                if (!advertisement.getDescription().contains(world)) {
                    //если не нашли это слово в описании
                    advertisements.remove(advertisement);
                    break;
                }
            }

        }
        return advertisements;

    }


    // удалить все объявления клиента
    public void deleteByUser(User user) {
        advertisementdao.deleteByUser(user);
    }

    // удалить конкретное объявление относительно юзера
    public void deleteByUserAndIdForUser(User user, Integer idForUser) {
        advertisementdao.deleteByUserAndIdForUser(user, idForUser);
    }

    // удалить объявление
    public void delete(Advertisement advertisement) {
        advertisementdao.delete(advertisement);
    }
}
