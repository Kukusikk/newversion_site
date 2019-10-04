package com.example.NedoAvito.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tag {
    @Id
  //  @Column(name="id")
    private String name;
    //дочернии тэги
    @OneToMany
    private Set<Tag> childCategory = new HashSet<>();
    //количество просмотров
    private int numberviews;
    //каким объявлениям принадлежат
    //объявление принадлежит одному тэгу
    //один тэг принадлежит многим объявлениям
    @OneToMany
    private Set<Advertisement> advertisements=new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Tag> getChildCategory() {
        return childCategory;
    }

    public void setChildCategory(Set<Tag> childCategory) {
        this.childCategory = childCategory;
    }

    public int getNumberviews() {
        return numberviews;
    }

    public void setNumberviews(int numberviews) {
        this.numberviews = numberviews;
    }

    public Set<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(Set<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }
}
