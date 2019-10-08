package com.example.NedoAvito.dao.User;

import com.example.NedoAvito.entity.User;
import com.example.NedoAvito.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserDaoImpl implements UserDao{
    @Autowired
    UserRepository userrepository;
    //выдать всех клиентов
    public  List<User> findAll(){return userrepository.findAll();}
    //выдать клиента по логину(первичн ключу)
    public Optional<User> findById(UUID iduser){return userrepository.findById(iduser);}
    //выдать клиента по логину(уникальному ключу)
    public Optional<User> findByLogin(String  login){return userrepository.findByLogin(login);}
    //сохранить клиента
    public User save(User user){return userrepository.save(user);}
    //удалить клиента
    public void delete(User user){userrepository.delete(user);}
    //удалить клиента по id
    public void deleteById(UUID id){userrepository.deleteById(id);}
    //удалить клиента по логину
    public void deleteByLogin(String login){userrepository.deleteByLogin(login);};
    //удаление всех постов
    public void deleteAll(){userrepository.deleteAll();}
}
