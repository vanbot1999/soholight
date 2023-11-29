package com.soholighting.sohoTeam8.service;

import com.soholighting.sohoTeam8.model.KidsImage;
import com.soholighting.sohoTeam8.mapper.KidsImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KidsImageService {
    @Autowired
    private KidsImageMapper kidsimageMapper;

    public List<KidsImage> findAll(){
        return kidsimageMapper.findAll();
    }
    public List<KidsImage> getRandomKidsImages() {
        List<KidsImage> images =  kidsimageMapper.findAll();
        Collections.shuffle(images);
        return images.subList(0, Math.min(images.size(), 2));
    }
    public List<KidsImage> getRandomKidsImagesByYear(String year) {

        List<KidsImage> allKidsByYear = kidsimageMapper.findAllByYear(year);
        Collections.shuffle(allKidsByYear);
        return allKidsByYear.stream().limit(3).collect(Collectors.toList());
    }
    public KidsImage getImageById(int imageId) {

        return kidsimageMapper.selectImageById(imageId);
    }
}
