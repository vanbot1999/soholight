package com.soholighting.sohoTeam8.cxService;

import com.soholighting.sohoTeam8.cxEnity.KidsImage;
import com.soholighting.sohoTeam8.cxMapper.KidsImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KidsImageService {
    @Autowired
    private KidsImageMapper kidsimageMapper;

    public List<com.soholighting.sohoTeam8.cxEnity.KidsImage> findAll(){
        return kidsimageMapper.findAll();
    }
    public List<KidsImage> getRandomKidsImages() {
        List<KidsImage> images =  kidsimageMapper.findAll(); // 获取所有图片
        Collections.shuffle(images); // 打乱顺序
        return images.subList(0, Math.min(images.size(), 2)); // 返回前两张图片
    }
    public List<KidsImage> getRandomKidsImagesByYear(String year) {
        // 假设你有一个获取所有图片的方法，并且KidsImage实体包含一个表示年份的字段
        List<KidsImage> allKidsByYear = kidsimageMapper.findAllByYear(year);
        Collections.shuffle(allKidsByYear);
        return allKidsByYear.stream().limit(3).collect(Collectors.toList());
    }

}
