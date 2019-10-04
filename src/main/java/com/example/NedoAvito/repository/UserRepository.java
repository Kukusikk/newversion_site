package com.example.NedoAvito.repository;
/////////////////////слой работы с бд

import com.example.NedoAvito.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public  interface  UserRepository extends CrudRepository<User, String> {
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

