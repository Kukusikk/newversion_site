package com.example.NedoAvito.dao.User;

import com.example.NedoAvito.entity.User;
import com.example.NedoAvito.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UsreDaoImpl implements UserDao{
    @Autowired
    UserRepository userrepository;
    //выдать всех клиентов
    public  List<User> findAll(){return userrepository.findAll();}
    //выдать клиента по логину(первичн ключу)
    public Optional<User> findById(String username){return userrepository.findById(username);}
    //сохранить клиента
    public User save(User user){return userrepository.save(user);}
    //удалить клиента
    public void delete(User user){userrepository.delete(user);}
    //удалить клиента по логину
    public void deleteById(String login){userrepository.deleteById(login);}
    //удаление всех постов
    public void deleteAll(){userrepository.deleteAll();}
}
