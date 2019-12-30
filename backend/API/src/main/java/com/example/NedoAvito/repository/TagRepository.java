package com.example.NedoAvito.repository;

import com.example.NedoAvito.entity.Advertisement;
import com.example.NedoAvito.entity.Tag;
import com.example.NedoAvito.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public  interface TagRepository extends CrudRepository<Tag, UUID> {
    //выдать все категории
    List<Tag> findAll();
    //выдать тэги заданного уровня
    List<Tag> findAllByLevel(int level);
    //выдать тэг с заданным id
    Optional<Tag> findByIdtag(UUID id);
    //добавить категорию
    Tag save(Tag tag);
    //выдать тэг с заданным уровнем
    Optional<Tag> findByLevel(int level);



    //удалить все категории
    void  deleteAll();
    //удалить категорию по id
    void deleteById(UUID id);
    //удаление категорию
    void delete(Tag tag);




}