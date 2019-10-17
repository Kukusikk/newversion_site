package com.example.NedoAvito.repository;
/////////////////////слой работы с бд

import com.example.NedoAvito.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public  interface  UserRepository extends CrudRepository<User, UUID> {
    //выдать всех клиентов
    List<User> findAll();
    //выдать клиента по id(первичн ключу)
    Optional<User> findById(UUID iduser);
    //выдать клиента по логину(уникальному ключу)
    Optional<User> findByLogin(String  login);
    //сохранить клиента
    User save(User user);
    //удалить клиента
    void delete(User user);
    //удалить клиента по id
    void deleteById(UUID id);
    //удалить клиента по логину
    void deleteByLogin(String login);
    //удаление всех клиентов
    void deleteAll();
}

