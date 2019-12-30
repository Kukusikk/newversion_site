package com.example.NedoAvito.servise;

import com.example.NedoAvito.dao.Tag.TagDaoImImpl;
import com.example.NedoAvito.entity.Advertisement;
import com.example.NedoAvito.entity.Tag;
import com.example.NedoAvito.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLIgnore;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
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
    public Tag update(Tag t){
        return tagDaoIm.save(t);
    }
    //удалить все тэги
    @GraphQLQuery
    public void  deleteAllTags(){tagDaoIm.deleteAll();}
    //удалить конкретный тэг
    @GraphQLQuery
    public void deleteTag(Tag tag){tagDaoIm.delete(tag);}
    //удалить тэг по id
    @GraphQLQuery
    public void deleteTagById(UUID id){tagDaoIm.deleteById(id);}
    @GraphQLQuery
    //выдать все тэги
    public List<Tag> findAllTags()
    { return tagDaoIm.findAll();}
    //выдать корневой тэг


    @GraphQLQuery
    public String findRootTagString() throws IOException {
        StringWriter writer = new StringWriter();
        // сама сериализация: 1-куда, 2-что
        Object t=tagDaoIm.findByLevel(0).orElseGet(() -> new Tag());
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, t);


        //преобразовываем все записанное во StringWriter в строку
        String result = writer.toString();
        return result;
    }

    @GraphQLQuery
    public Tag findRootTag(){
        //выдать корневой тэг, иначе пустой объект
        return tagDaoIm.findByLevel(0).orElseGet(() -> new Tag());
    }
    //выдать тэг с заданным id
    @GraphQLQuery
    public Tag findById(UUID id)
    {return tagDaoIm.findById(id).orElseGet(() -> new Tag()); }




    //--------------------------------------------------------------------------------------------------------------------------------------------
    //тестирование графкуель
    //пример отдачи элимента
//    @GraphQLQuery
//    public User test(@GraphQLArgument(name = "testLine") String testLine) {
//        User user= new User(testLine, "testphone", "testphoto", null, null);
//        user.setIduser(UUID.randomUUID());
//        return user;
//
//    }
    //пример отдачи сложной структуры
//    @GraphQLQuery
//    public ArrayList<User> testList(@GraphQLArgument(name = "testname1") String testname1,@GraphQLArgument(name = "testname2") String testname2 ) {
//        ArrayList<User> testlist = new ArrayList<User>();
//        User user1=new User(testname1, "myphone1", "myphoto1",  new HashSet<>(), new HashSet<>());
//        user1.setIduser(UUID.randomUUID());
//        testlist.add(user1);
//        User user2=new User(testname2, "myphone2", "myphoto2",  new HashSet<>(), new HashSet<>());
//        user2.setIduser(UUID.randomUUID());
//        testlist.add(user2);
//        return testlist;
//    }
//------------------------------------------------------------------------------------------------------------------------------------------------------
    //добавить тэг
    @GraphQLQuery
    public Tag saveTag(Tag tag){return tagDaoIm.save(tag);}




    @GraphQLQuery
    //вернуть set всех дочерних тэгов для данного тэга включая его
    public Set<Tag> findAllChildTagsforone(Tag tag){
        Set<Tag>result=new HashSet<>();
        result.add(tag);
        return findAllChildTagsforSet(tag.getChildCategory(),result);

    }

    @GraphQLQuery
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





    @GraphQLQuery
    //вернуть список тэгов по их id
    public Set<Tag>findTagsByIdes(Set<UUID> idtags){
        Set<Tag>result=new HashSet<>();
        for(UUID idtag:idtags){
            Object huy=tagDaoIm.findAll();
            Optional<Tag> z=tagDaoIm.findById(idtag);
            Tag x=z.orElseGet(() -> new Tag());

            result.add(x);
//            result.add(findTagById(idtag));
        }
        return result;
    }
    @GraphQLQuery
    //вернуть тэг по его id
    public Tag findTagById(UUID id){
        Optional<Tag> z=tagDaoIm.findById(id);

        return tagDaoIm.findById(id).orElseGet(() -> new Tag());
    }
}
