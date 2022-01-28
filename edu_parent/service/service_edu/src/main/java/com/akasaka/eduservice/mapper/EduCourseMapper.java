package com.akasaka.eduservice.mapper;

import com.akasaka.eduservice.entity.EduCourse;
import com.akasaka.eduservice.entity.frontvo.CourseWebVo;
import com.akasaka.eduservice.entity.vo.CoursePublishVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-11-02
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {

    public CoursePublishVo getPublishCourseInfo(String courseId);

    // 根据课程id，编写sql语句查询课程
    CourseWebVo getBaseCourseInfo(String courseId);
}
