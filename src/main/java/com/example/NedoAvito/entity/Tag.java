package com.example.NedoAvito.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Tags")
public class Tag {
    @Id
  //  @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID idtag;
    @Column(unique=true)
    private String name;
    //родительский тэг
    @OneToOne
    private Tag parenttag;
    //дочернии тэги
    //при удалении родительского тэга должны удаляться дочернии
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Tag> childCategory = new HashSet<>();
    //количество просмотров
    private int numberviews;
    //каким объявлениям принадлежат
    //объявление принадлежит одному тэгу
    //один тэг принадлежит многим объявлениям
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Advertisement> advertisements=new HashSet<>();
    public Tag(){}

    public Tag getParenttag() {
        return parenttag;
    }

    public void setParenttag(Tag parenttag) {
        this.parenttag = parenttag;
    }

    public UUID getIdtag() {
        return idtag;
    }

    public void setIdtag(UUID idtag) {
        this.idtag = idtag;
    }

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
