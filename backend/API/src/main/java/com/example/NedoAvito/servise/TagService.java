package com.example.NedoAvito.servise;

import com.example.NedoAvito.dao.Tag.TagDaoImImpl;
import com.example.NedoAvito.entity.Advertisement;
import com.example.NedoAvito.entity.Tag;
import com.example.NedoAvito.entity.User;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLIgnore;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@GraphQLApi
public class TagService {
    @Autowired
    TagDaoImImpl tagDaoIm;
    //создать новый тэг
    public Tag createTag(String name, Tag parenttag){
        Tag t=new Tag(name,parenttag);
//        return tagDaoIm.save(new Tag(name,parenttag));
        return tagDaoIm.save(t);
    }
    //удалить все тэги
    public void  deleteAllTags(){tagDaoIm.deleteAll();}
    //удалить конкретный тэг
    public void deleteTag(Tag tag){tagDaoIm.delete(tag);}
    //удалить тэг по id
    public void deleteTagById(UUID id){tagDaoIm.deleteById(id);}
    //выдать все тэги
    public List<Tag> findAllTags(){ return tagDaoIm.findAll();}
    //выдать корневой тэг

    @GraphQLQuery
    public Tag findRootTag(){
        //выдать корневой тэг, иначе пустой объект
        return tagDaoIm.findByLevel(0).orElseGet(() -> new Tag());
    }
    //пример отдачи элимента
    @GraphQLQuery
    public User test(@GraphQLArgument(name = "testLine") String testLine) {
        return new User(testLine, "phone", "photo", null, null);
    }
    //пример отдачи сложной структуры
    @GraphQLQuery
    public ArrayList<User> testList(@GraphQLArgument(name = "testname1") String testname1,@GraphQLArgument(name = "testname2") String testname2 ) {
        ArrayList<User> testlist = new ArrayList<User>();
        testlist.add(new User(testname1, "phone", "photo", null, null));
        testlist.add(new User(testname2, "phone", "photo", null, null));
        return testlist;
    }

    //добавить тэг
    public Tag saveTag(Tag tag){return tagDaoIm.save(tag);}



    //вернуть set всех дочерних тэгов для данного тэга включая его
    public Set<Tag> findAllChildTagsforone(Tag tag){
        Set<Tag>result=new HashSet<>();
        result.add(tag);
        return findAllChildTagsforSet(tag.getChildCategory(),result);

    }
    //вернуть всех дочерних Тэгов для данного Set тэгов
    public Set<Tag> findAllChildTagsforSet(Set<Tag> tags, Set<Tag>result){
        if (tags==null){
            return result;
        }
        result.addAll(tags);
        for(Tag child:tags) {
            result.addAll(findAllChildTagsforSet(child.getChildCategory(),result));
        }
        return result;
    }
}
