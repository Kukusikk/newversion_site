package com.example.NedoAvito.dao.UserSecure;

import com.example.NedoAvito.entity.UserSecure;

import java.util.UUID;

public interface UserSecureDao {
    //добавить юзера
    UserSecure save(UserSecure userSecure);
    //удалить юзера с данным логином
    void deleteByLogin(String login);
    //удалить юзера с данным token
    void deleteByUsedtoken(UUID usedtoken);
    //найти юзера по логину
    UserSecure findByLogin(String login);
    //найти юзера по token
    UserSecure findByUsedtoken(UUID usedtoken);
    //удалить всех клиентов
    void deleteAll();
    void delete(UserSecure userSecure);
}
