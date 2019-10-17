package com.example.NedoAvito.servis;

import com.example.NedoAvito.dao.Advertisement.AdvertisementDaoImpl;
import com.example.NedoAvito.dao.Tag.TagDaoImImpl;
import com.example.NedoAvito.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
@Service
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
    public void  deleteAll(){tagDaoIm.deleteAll();}
    //удалить конкретный тэг
    public void delete(Tag tag){tagDaoIm.delete(tag);}
    //удалить тэг по id
    public void deleteById(UUID id){tagDaoIm.deleteById(id);}
    //выдать все тэги
    public List<Tag> findAll(){ return tagDaoIm.findAll();}

    //добавить тэг
    public Tag save(Tag tag){return tagDaoIm.save(tag);}



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
