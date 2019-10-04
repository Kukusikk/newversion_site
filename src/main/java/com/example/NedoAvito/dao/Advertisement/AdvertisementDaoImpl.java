package com.example.NedoAvito.dao.Advertisement;


import com.example.NedoAvito.entity.Advertisement;
import com.example.NedoAvito.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdvertisementDaoImpl implements AdvertisementDao {
    @Autowired
    private AdvertisementRepository advertisementRepository;
 //   @Override
 //   public List<Advertisement> findAll(){     return  advertisementRepository.findAll();  }

}
