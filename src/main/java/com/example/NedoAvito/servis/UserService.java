package com.example.NedoAvito.servis;

import com.example.NedoAvito.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository users;
//получить юзера по id
    //получить корзину юзера в виде {things:{name:'',qventity:'',price:''},{...},....,total:''}
    //получить
}
