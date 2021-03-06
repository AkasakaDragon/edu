package com.akasaka.eduservice.service;

import com.akasaka.eduservice.entity.EduSubject;
import com.akasaka.eduservice.entity.subject.OneSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-10-31
 */
public interface EduSubjectService extends IService<EduSubject> {

    // 添加课程分类
    void saveSubject(MultipartFile file,EduSubjectService subjectService);

    // 课程分类列表（树形）
    List<OneSubject> getAllOneTwoSubject();
}
