package com.example.NedoAvito.dao.User;

import com.example.NedoAvito.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    //выдать всех клиентов
    List<User> findAll();
    //выдать клиента по логину(первичн ключу)
    Optional<User> findById(String username);
    //сохранить клиента
    User save(User user);
    //удалить клиента
    void delete(User user);
    //удалить клиента по логину
    void deleteById(String login);
    //удаление всех постов
    void deleteAll();

}
