package com.example.NedoAvito.repository;

import com.example.NedoAvito.entity.UserSecure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public  interface  UserSecureRepository extends CrudRepository<UserSecure, UUID> {
    //добавить юзера
    UserSecure save(UserSecure userSecure);
    //удалить юзера с данным логином
    void deleteByLogin(String login);
    //удалить юзера с данным token
    void deleteByUsedtoken(UUID usedtoken);
    //удалить клиента
    void delete(UserSecure userSecure);
    //найти юзера по логину
    UserSecure findByLogin(String login);
    //найти юзера по token
    UserSecure findByUsedtoken(UUID usedtoken);
    //удалить всех клиентов
    void deleteAll();
}

