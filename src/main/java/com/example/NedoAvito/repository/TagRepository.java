package com.example.NedoAvito.repository;

import com.example.NedoAvito.entity.Tag;
import com.example.NedoAvito.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public  interface TagRepository extends CrudRepository<Tag, String> {
    //выдать топ 10 категорий
    List<Tag> findAll();
    //добавить категорию
    //добавить подкатегорию для категории
    //удалить категорию
    //удалить подкатегорию для категории



}