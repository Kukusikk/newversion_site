package com.example.NedoAvito.servise;

import com.example.NedoAvito.conteiner.Filter;
import com.example.NedoAvito.dao.Advertisement.AdvertisementDaoImpl;
import com.example.NedoAvito.entity.Advertisement;
import com.example.NedoAvito.entity.Tag;
import com.example.NedoAvito.entity.User;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.*;
import java.util.stream.Collectors;

@Service
@GraphQLApi
public class AdvertisementServise {
    @Autowired
    AdvertisementDaoImpl advertisementdao;
    @Autowired
    TagService tagService;
    @Autowired
    UserService userService;

    //сохранить объявление
    public Advertisement saveAdvertisement(Advertisement advertisement) {
        return advertisementdao.save(advertisement);
    }

    // удалить объявление по ее id
    public void deleteAdvertisementById(UUID id) {
        advertisementdao.deleteById(id);
    }
     @GraphQLQuery
    //показать топ  самых популярных 10 объявление
    public List<Advertisement> findAdvertisementsByOrderByNumberviewsDesc() {
        return advertisementdao.findAllByOrderByNumberviewsDesc().stream().limit(10).collect(Collectors.toList());
    }

    //выдать конкретное объявление по ее id
    public Optional<Advertisement> findAdvertisementById(UUID id) {
        return advertisementdao.findById(id);
    }

    // выдать все объявление по заданному в поисковике фильтру
    @GraphQLQuery
    public List<Advertisement> AdvertisementsByFiltersearch(Filter filter) {
        List<Advertisement> advertisements = new ArrayList<>();
        List<Advertisement> result = new ArrayList<>();
    //    result= findAdvertisementsByOrderByNumberviewsDesc();
        boolean n=filter.getUsefilter();
   //     if (!n){
   //         System.out.println(9);
//            return result;
//        }
        boolean help=false;
        switch (filter.getSortingprinciple()) {
            case 0:
                //выдача с ценой+имя+наличие в тэге+сортировка по популярности
                advertisements = advertisementdao.findAllByOrderByNumberviewsDesc();
                break;
            case 2:
                advertisements=advertisementdao.findAllByOrderByDateAsc();
                break;

            case 1:
                //выдача c ценой+имя+наличие в тэге+сортировка по цене
                advertisements = advertisementdao.findAllByOrderByPriceAsc();
                break;
        }
        //выдача с ценой+имя+наличие в тэге+сортировка по дате\
        Set<UUID>a=filter.getIdtag();
        Set <Tag> x= new HashSet<>();
        //если был выбран хоть какой то тэг
        if (a.size()>0){
        Set<Tag> z=tagService.findTagsByIdes(filter.getIdtag());
        x=tagService.findAllChildTagsforSet(z,new HashSet<>());}


        for(Advertisement i: advertisements){
            if (!i.getName().toLowerCase().contains(filter.getName().toLowerCase())){
//            if(!i.getName().equals(filter.getName())){
                if (filter.getName().length()!=0){
                continue;}
                //         advertisements.remove(i);
            }
            if(i.getPrice()>filter.getTopprice()){
                if (filter.getTopprice()!=0){
                continue;}
                //               advertisements.remove(i);
            }
            if(i.getPrice()<filter.getLowerprice()){
                if(filter.getLowerprice()!=0){
                continue;}
                //              advertisements.remove(i);
            }
            if (n){
            for (Tag j : x){

                if (j.getIdtag().equals(i.getTag().getIdtag())){
                    help=true;
                    break;}
            }
            if(!help) {
                continue;
                //                   advertisements.remove(i);
            }}
            result.add(i);

        }

        return result;

    }

    @GraphQLQuery
    // удалить все объявления клиента
    public void deleteAdvertisementByUser(User user) {
        advertisementdao.deleteByUser(user);
    }
    @GraphQLQuery
    // удалить конкретное объявление относительно юзера
    public void deleteAdvertisementByUserAndIdForUser(User user, Integer idForUser) {
        advertisementdao.deleteByUserAndIdForUser(user, idForUser);
    }
    @GraphQLQuery
    // удалить объявление
    public void deleteAdvertisement(Advertisement advertisement) {
        advertisementdao.delete(advertisement);
    }
}
