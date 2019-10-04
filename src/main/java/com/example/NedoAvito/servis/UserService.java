package com.example.NedoAvito.servis;

import com.example.NedoAvito.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository users;
//    выдать профиль юзера по его логину
//    выдать все записи данного юзера
//    выдать конкретную запись данного юзраа
//    GET /person/{login}/backet/{token} -                                  выдать корзину юзера по его логину
//удаление всех клиентов
    //удалить конкретного клинта
}
