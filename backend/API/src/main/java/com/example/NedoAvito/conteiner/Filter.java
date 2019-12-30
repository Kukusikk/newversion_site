package com.example.NedoAvito.conteiner;

import com.example.NedoAvito.entity.Advertisement;
import com.example.NedoAvito.entity.Tag;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

//класс, объект которого создается при вводе поисковых фильтров на стороне клиента
public class Filter {
    //название поискового объекта
    String name;

    //все дерево тэгов со своими дочерними тэгами
    private Set<UUID> idtags=new HashSet<>();

    //верхняя граница цены
    Integer topprice;
    //нижняя граница цена
    Integer lowerprice;
    //принцип сортировки
    Integer sortingprinciple;
    //надо ли использовать этот фильтр
    boolean usefilter;

    public boolean getUsefilter() {
        return usefilter;
    }

    public void setUsefilter(boolean usefilter) {
        this.usefilter = usefilter;
    }

    public Filter(boolean usefilter, Integer Topprice, Integer Lowprice, Integer SortingPrincipl, String Name, Set<UUID> Idtags){
        this.usefilter=usefilter;
        this.topprice=Topprice;
        this.sortingprinciple=SortingPrincipl;
        this.lowerprice=Lowprice;
        this.idtags=Idtags;
        this.name=Name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UUID> getIdtag() {
        return idtags;
    }

    public void setIdtag(Set<UUID> idtag) {
        this.idtags = idtag;
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

    public Integer getSortingprinciple() {
        return sortingprinciple;
    }

    public void setSortingprinciple(Integer sortingprinciple) {
        this.sortingprinciple = sortingprinciple;
    }
}
