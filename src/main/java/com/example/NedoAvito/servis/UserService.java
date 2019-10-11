package com.example.NedoAvito.servis;

import com.example.NedoAvito.dao.User.UserDaoImpl;
import com.example.NedoAvito.entity.Advertisement;
import com.example.NedoAvito.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

//вся бизнесс логика
@Service
public class UserService {
    //промежуточная прослойка взаимодействия с бд
    @Autowired
    private UserDaoImpl userdao;
    //создать нового юзера
    public User save(User user){return userdao.save(user);}
    //показать всех клиентов
    public List<User> findAll() {
        return userdao.findAll();
    }

    // выдать профиль клиента по его id
    public Optional<User> findById(UUID iduser) {
        return userdao.findById(iduser);
    }

    //выдать клиента по логину(уникальному ключу)
    public Optional<User> findByLogin(String login) {
        return userdao.findByLogin(login);
    }

    //выдать все записи данного юзера
    public Set<Advertisement> findByLoginAdvertisements(String login) {
        User u = userdao.findByLogin(login).orElse(new User());
        return u.getAdvertisements();
    }

    //    выдать конкретное объявление данного клиента
    public Advertisement findByLoginAdvertisementById(String login, UUID id) {
        User u = userdao.findByLogin(login).orElse(new User());
        for (Advertisement advertisement : u.getAdvertisements()) {
            if (advertisement.getId() == id) {
                return advertisement;
            }
        }
        return null;

    }


    //выдать корзину клиента по его логину
    public Set<Advertisement> findByLoginCart(String login) {
        User u = userdao.findByLogin(login).orElse(new User());
        return u.getCart();
    }

    //удаление всех клиентов
    public void deleteAll() {
        userdao.deleteAll();
    }

    //удалить конкретного клинта по логину
    public void deleteByLogin(String login) {
        userdao.deleteByLogin(login);
    }

    //удалить конкретного клиента по id
    public void deleteById(UUID id) {
        userdao.deleteById(id);
    }
}
