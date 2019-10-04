package com.example.NedoAvito.repository;

import com.example.NedoAvito.entity.User;
import com.example.NedoAvito.entity.UserSecure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public  interface  UserSecureRepository extends CrudRepository<UserSecure, String> {
    //добавить юзера
    //удалить юзера с данным логином
    //изменить пароль юзера с данным логином
    //удалить 2 токена и время у юзера с заданным логином(когда выходим)
    //изменить 2 токена и записать время когда это произошло

}

