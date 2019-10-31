package com.example.NedoAvito.dao.UserSecure;

import com.example.NedoAvito.entity.UserSecure;
import com.example.NedoAvito.repository.UserSecureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserSecureDaoImpl implements  UserSecureDao{
    @Autowired
    public UserSecureRepository userSecureRepository;
    //добавить юзера
    public UserSecure save(UserSecure userSecure){return userSecureRepository.save(userSecure);}
    //удалить юзера с данным логином
    public void deleteByLogin(String login){userSecureRepository.deleteByLogin(login);}
    //удалить юзера с данным token
    public void deleteByUsedtoken(UUID usedtoken){userSecureRepository.deleteByUsedtoken(usedtoken);}
    //найти юзера по логину
    public UserSecure findByLogin(String login){return userSecureRepository.findByLogin(login);}
    //найти юзера по token
    public UserSecure findByUsedtoken(UUID usedtoken){return userSecureRepository.findByUsedtoken(usedtoken);}
    //удалить всех клиентов
    public void deleteAll(){userSecureRepository.deleteAll();}
    public void delete(UserSecure userSecure){userSecureRepository.delete(userSecure);}
}
