package com.example.NedoAvito.dao.Tag;

import com.example.NedoAvito.entity.Advertisement;
import com.example.NedoAvito.entity.Tag;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TagDao {
    //выдать все категории
    List<Tag> findAll();
    //выдать тэги заданного уровня
    List<Tag> findAllByLevel(int level);
    //выдать тэг с заданным id
    Optional<Tag> findById(UUID id);
    //добавить категорию
    Tag save(Tag tag);


    //удалить все категории
    void  deleteAll();
    //удалить категорию по id
    void deleteById(UUID id);
    //удаление категорию
    void delete(Tag tag);



}
