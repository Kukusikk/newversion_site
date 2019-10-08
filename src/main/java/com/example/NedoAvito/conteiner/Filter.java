package com.example.NedoAvito.conteiner;

import com.example.NedoAvito.entity.Advertisement;
import com.example.NedoAvito.entity.Tag;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//класс, объект которого создается при вводе поисковых фильтров на стороне клиента
public class Filter {
    //название поискового объекта
    String name;
    //слова в описании, совпадение с которыми будем искать в описании объекта
    List<String> fordiscription;
    //все дерево тэгов со своими дочерними тэгами
    Set<Tag> tags=new HashSet<>();
    //верхняя граница цены
    Integer topprice;
    //нижняя граница цена
    Integer lowerprice;
    //принцип сортировки
    SortingPrinciple sortingprinciple;
    Filter(){
        this.topprice=this.lowerprice=-1;
        this.sortingprinciple=SortingPrinciple.popularity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFordiscription() {
        return fordiscription;
    }

    public void setFordiscription(List<String> fordiscription) {
        this.fordiscription = fordiscription;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Integer getTopprice() {
        return topprice;
    }

    public void setTopprice(Integer topprice) {
        this.topprice = topprice;
    }

    public Integer getLowerprice() {
        return lowerprice;
    }

    public void setLowerprice(Integer lowerprice) {
        this.lowerprice = lowerprice;
    }

    public SortingPrinciple getSortingprinciple() {
        return sortingprinciple;
    }

    public void setSortingprinciple(SortingPrinciple sortingprinciple) {
        this.sortingprinciple = sortingprinciple;
    }
}
