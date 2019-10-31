package com.example.NedoAvito.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Advertisements")
public class Advertisement {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
 //   @Column(name="id")
    private UUID idAdvertisement;//номер в общем риестре записей
  //  много объявлений принадлежат одному юзеру
    @NotNull
    @OneToOne (fetch = FetchType.EAGER)//при удалении пользователя удаляются его объявления
    @JoinColumn(name = "idAdvertisement")
    private User user= new User();
    private int idForUser;//номер относительно ее автора
    private int price;
    @NotNull
    private String name;
   // private List<String> photo2;
    private String description;
    //количество просмотров
    private int numberviews;
    //много объявлений принадлежат одному тэгу
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAdvertisement")
    //здесь хрениться один тэг - самый дочерний
    private Tag tag= new Tag();
    //
    //дата создания объевления
    private Date date = new Date();
    public Advertisement(){}

    public UUID getIdAdvertisement() {
        return idAdvertisement;
    }

    public void setIdAdvertisement(UUID idAdvertisement) {
        this.idAdvertisement = idAdvertisement;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Advertisement(@NotNull User user) {

        this.user = user;
        this.idForUser = 8;
        this.price = 6;
        this.name = "j";
        this.description = "description";
        this.numberviews = 3;


    }

    public UUID getId() {
        return idAdvertisement;
    }

    public void setId(UUID idAdvertisement) {
        this.idAdvertisement = idAdvertisement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getIdForUser() {
        return idForUser;
    }

    public void setIdForUser(int idForUser) {
        this.idForUser = idForUser;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberviews() {
        return numberviews;
    }

    public void setNumberviews(int numberviews) {
        this.numberviews = numberviews;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
