package com.example.NedoAvito.entity;

import net.bytebuddy.dynamic.scaffold.TypeInitializer;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

//класс клиента
@Entity
@Table(name = "Users")
public class User {
    @Id
//    @Column(name="login")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID iduser;
    @Column(unique=true)
    private String login;
    private String phone;
    //ссылка на фото
    private String photo;

    //корзина - содержит ссылки понравившихся объявлений
    //одно объявление может быть во многих корзинах
    //в одной корзине может быть много объявлений
    //однонаправленный
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Users_Advertisements",
            joinColumns = { @JoinColumn(name = "iduser") },
            inverseJoinColumns = { @JoinColumn(name = "idAdvertisement") })
    private Set<Advertisement> cart = new HashSet<>();


    public User(String login, String phone, String photo, Set<Advertisement> cart, Set<Advertisement> advertisements) {
        this.login = login;
        this.phone = phone;
        this.photo = photo;
        this.cart = cart;
        this.advertisements = advertisements;
    }
    public User(){}

    //ссылки на объявления этого пользователя
    //один пользователь имеет много объявлений. одно объявление имеет одного хозяина
    //при удалении юзера автоматом удалять все его сообщения
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Advertisement> advertisements = new HashSet<>();

    public UUID getIduser() {
        return iduser;
    }

    public void setIduser(UUID iduser) {
        this.iduser = iduser;
    }

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
