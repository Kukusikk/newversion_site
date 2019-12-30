package com.example.NedoAvito.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity

@Table(name = "Tags")
public class Tag {
    @Id
  //  @Column(name="id")
    @JsonProperty
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID idtag;
    @Column(unique=true)
    @JsonProperty
    private String name;
    //родительский тэг
    @OneToOne
    @JsonProperty
    private Tag parenttag ;//= new Tag();
    //дочернии тэги
    //при удалении родительского тэга должны удаляться дочернии
    @JsonProperty
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="parenttag")
    private Set<Tag> childCategory = new HashSet<>();
    //уровень тэга
    int level;
    //каким объявлениям принадлежат
    //объявление принадлежит одному тэгу
    //один тэг принадлежит многим объявлениям
    @OneToMany(fetch = FetchType.EAGER)
    @JsonProperty
    private Set<Advertisement> advertisements=new HashSet<>();
    public Tag(){}
    //создание нового тэга
    //у него в описании пока что знаем только родительский Тэг и его имя
    //у корневого тэга parenttag=null
    public Tag(String name, Tag parenttag) {
        this.name = name;
        this.parenttag = parenttag;
        this.childCategory = null;
        this.advertisements = null;
        this.advertisements=new HashSet<>();

        if (parenttag!=null){
            this.level=1+parenttag.getLevel();
            if (parenttag.getChildCategory()==null) {
                Set<Tag>child= Stream.of(this).collect(Collectors.toCollection(HashSet::new));
                parenttag.setChildCategory(child);
            }else {parenttag.getChildCategory().add(this);}
        }
        else {this.level = 0;}

    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

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


    public Set<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(Set<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }
}
