package com.example.NedoAvito.servise;

import com.example.NedoAvito.dao.UserSecure.UserSecureDaoImpl;
import com.example.NedoAvito.entity.UserSecure;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class UserSecureService {
    @Autowired
    UserSecureDaoImpl userSecureDao;
    //регистрация(сохраняем клиента)
    public UserSecure registration(UserSecure userSecure){return userSecureDao.save(userSecure);}
    //регистрация(создаем и сохраняем клиента)
    public UserSecure registration(String login, String password){return userSecureDao.save(new UserSecure(login,password));}
    //только что авторизовался - выдаем и меняем у клиента токен
    public UserSecure authorization(UserSecure userSecure){
        userSecure.setUsedtoken(UUID.randomUUID());
        return userSecureDao.save(userSecure);}
    //изменяем пароль клиента
    public UserSecure changepassword(UserSecure userSecure,String password){
        userSecure.setPassword(password);
        return userSecureDao.save(userSecure);
    }
    //удалить клиента
    public void deleteUser(UserSecure userSecure){userSecureDao.delete(userSecure);}
    //удалить клиента по логину
    public void deleteUserByLogin(String login){userSecureDao.deleteByLogin(login);}
    //удалить всех пользователей
    public void deleteAllUsers(){userSecureDao.deleteAll();}
    //найти клиента по логину
    public UserSecure findUserByLogin(String login){ return userSecureDao.findByLogin(login);}
    }
