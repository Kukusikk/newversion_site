package com.example.NedoAvito.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Advertisement {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
 //   @Column(name="id")
    private int id;//номер в общем риестре записей
  //  много объявлений принадлежат одному юзеру
    @NotNull
    @OneToOne (cascade = CascadeType.ALL)//при удалении пользователя удаляются его объявления
    @JoinColumn(name = "id")
    private User user;
    private int idForUser;//номер относительно ее автора
    private int price;
    @NotNull
    private String name;
   // private List<String> photo2;
    private String description;
    //количество просмотров
    private int numberviews;
    //много объявлений принадлежат одному тэгу
    @OneToOne
    @JoinColumn(name = "id")
    private Tag tag;

    public Advertisement(@NotNull User user) {

        this.user = user;
        this.idForUser = 8;
        this.price = 6;
        this.name = "j";
        this.description = "description";
        this.numberviews = 3;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
