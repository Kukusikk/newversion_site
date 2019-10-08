package com.example.NedoAvito.servis;

import com.example.NedoAvito.conteiner.Filter;
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
//сохранить запись
    public Advertisement save(Advertisement advertisement){return advertisementdao.save(advertisement);}
// удалить запись по ее id
    public void deleteById(UUID id){advertisementdao.deleteById(id);}
//показать топ  самых популярных 10 записей
   public List<Advertisement> findAllByOrderByNumberviewsDesc(){
    return advertisementdao.findAllByOrderByNumberviewsDesc().stream().limit(10).collect(Collectors.toList());
    }
//выдать конкретную запись по ее id
 public  Optional<Advertisement> findById(UUID id){return advertisementdao.findById(id);}
// выдать все записи по заданному в поисковике фильтру(категория,подкатегория( default=all) цена имя описание начиная с самых популярных
//    public List<Advertisement>filtersearch(Filter filter){
//
//        List<Advertisement> advertisements = new ArrayList<>();
//        switch (filter.getSortingprinciple()){
//            case popularity:
//                advertisements=advertisementdao.findAllByOrderByNumberviewsDesc();
//                break;
//            case age:
//                advertisements=advertisementdao.findAllByOrderByDateAsc();
//                break;
//            case price:
//                advertisements=advertisementdao.findAllByOrderByPriceAsc();
//                break;
//        }//накладываем фильтры
//        for (Advertisement advertisement:advertisements){
//            boolean helpvar=false;
//            //проверяем соответсвие цене
//            if ((filter.getTopprice()>=0 && advertisement.getPrice()>filter.getTopprice()) ||
//                    (filter.getLowerprice()>=0 && advertisement.getPrice()<filter.getTopprice()))
//            {
//                advertisements.remove(advertisement);
//                continue;
//            }
//
//            //проверяем соответсвие названию
//            if (advertisement.getName()!=filter.getName()) {
//                advertisements.remove(advertisement);
//                continue;
//            }
//            //проверяем наличие этих слов в описании
//            for(String world: filter.getFordiscription()) {
//                //идем по слову в описании и находим его в строке описания товара
//                if (!advertisement.getDescription().contains(world)) {
//                    //если не нашли это слово в описании
//                    advertisements.remove(advertisement);
//                    helpvar=true;
//                    break;
//                }
//                }
//            if (helpvar){continue;}
//            //проверяем пренадлежность тэгу
//            if (!Aracontainssetoftags(advertisement.getTag(),filter.getTags())){
//                advertisements.remove(advertisement);
//            }
//
//        }
//        return advertisements;
//
//    }

    //функция получает на вход тэг с подтэгами, которому пренадлежит данное объявение
    //второй аргумент это коллекция тэгов с подтэгами одному из которых он должен принадлежать
    //принадлежит - вернуть true
    //иначе вернуть false
//    public boolean Aracontainssetoftags(Tag tagadvertisement, Set<Tag> filtertags){
//
//    }

// удалить все посты юзера
    public     void deleteByUser(User user){advertisementdao.deleteByUser(user);}
// удалить клнкретный пост относительно юзера у определенного юзера
    public void deleteByUserAndIdForUser(User user, Integer idForUser){advertisementdao.deleteByUserAndIdForUser(user, idForUser);}
// удалить пост
    public void delete(Advertisement advertisement){advertisementdao.delete(advertisement);}
}
