package com.example.NedoAvito.entity;

import net.bytebuddy.dynamic.scaffold.TypeInitializer;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//класс клиента
@Entity
@Table(name = "User1")
public class User {
    @Id
//    @Column(name="login")
    private String login;
    private String phone;
    //ссылка на фото
    private String photo;

    //корзина - содержит ссылки понравившихся объявлений
    //одно объявление может быть во многих корзинах
    //в одной корзине может быть много объявлений
    //однонаправленный
    @ManyToMany
    @JoinTable(name = "USER_Advertisement",
            joinColumns = { @JoinColumn(name = "login") },
            inverseJoinColumns = { @JoinColumn(name = "id") })
    private Set<Advertisement> cart = new HashSet<>();

    public User( String login, String phone, String photo) {
        this.login = login;
        this.phone = phone;
        this.photo = photo;

    }

    //ссылки на объявления этого пользователя
    //один пользователь имеет много объявлений. одно объявление имеет одного хозяина
    @OneToMany
    private Set<Advertisement> advertisements = new HashSet<>();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Set<Advertisement> getCart() {
        return cart;
    }

    public void setCart(Set<Advertisement> cart) {
        this.cart = cart;
    }

    public Set<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(Set<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }
}
