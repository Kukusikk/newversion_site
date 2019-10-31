package com.example.NedoAvito.dao.Tag;

import com.example.NedoAvito.entity.Advertisement;
import com.example.NedoAvito.entity.Tag;
import com.example.NedoAvito.repository.TagRepository;
import com.example.NedoAvito.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class TagDaoImImpl implements  TagDao{
    @Autowired
    TagRepository tagRepository;
    //выдать все категории
    public List<Tag> findAll(){ return tagRepository.findAll();}
    //выдать тэги заданного уровня
    public List<Tag> findAllByLevel(int level){return tagRepository.findAllByLevel(level);}
    //выдать тэг с заданным id
    public Optional<Tag> findById(UUID id){return tagRepository.findById(id);}
    //добавить категорию
    public Tag save(Tag tag){return tagRepository.save(tag);}
    //выдать тэг с заданным уровнем
    public Optional<Tag> findByLevel(int level){return tagRepository.findByLevel(level);}


    //удалить все категории
    public void  deleteAll(){tagRepository.deleteAll();}
    //удалить категорию по id
    public void deleteById(UUID id){tagRepository.deleteById(id);}
    //удаление категорию
    public void delete(Tag tag){tagRepository.delete(tag);}


}
