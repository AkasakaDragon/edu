package com.akasaka.eduservice.service.impl;

import com.akasaka.eduservice.client.VodClient;
import com.akasaka.eduservice.entity.EduVideo;
import com.akasaka.eduservice.mapper.EduVideoMapper;
import com.akasaka.eduservice.service.EduVideoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-11-02
 */
@Service
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {

    // 注入vodClient
    @Autowired
    private VodClient vodClient;
    //1 根据课程id删除小节
    @Override
    public void removeVideoByCourseId(String courseId) {
        // 根据课程id查询课程所有的视频id
        QueryWrapper<EduVideo> wrapperVideo = new QueryWrapper<>();
        wrapperVideo.eq("course_id",courseId);
        List<EduVideo> eduVideoList = baseMapper.selectList(wrapperVideo);

        // List<EduVideo>变成List<String>
        List<String> videoIds = new ArrayList<>();
        for (int i = 0; i < eduVideoList.size(); i++) {
            EduVideo eduVideo = eduVideoList.get(i);
            String videoSourceId = eduVideo.getVideoSourceId();
            if (!StringUtils.isEmpty(videoSourceId)){
                // 放到videoIds集合里面
                videoIds.add(videoSourceId);
            }
        }

        // 根据多个视频id删除多个视频
        if (videoIds.size()>0){
            vodClient.deleteBatch(videoIds);
        }

        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        baseMapper.delete(wrapper);
    }
}
