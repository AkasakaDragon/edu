package com.akasaka.eduservice.controller.front;

import com.akasaka.commonutils.R;
import com.akasaka.eduservice.entity.EduCourse;
import com.akasaka.eduservice.entity.EduTeacher;
import com.akasaka.eduservice.entity.chapter.ChapterVo;
import com.akasaka.eduservice.entity.frontvo.CourseFrontVo;
import com.akasaka.eduservice.entity.frontvo.CourseWebVo;
import com.akasaka.eduservice.service.EduChapterService;
import com.akasaka.eduservice.service.EduCourseService;
import com.akasaka.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eduservice/coursefront")
@CrossOrigin
public class CourseFrontController {

    @Autowired
    private EduCourseService courseService;

    @Autowired
    private EduChapterService chapterService;

    //1 条件查询带分页查询课程
    @PostMapping("getFrontCourseList/{page}/{limit}")
    public R getFrontCourseList(@PathVariable long page, @PathVariable long limit,
                                @RequestBody(required = false) CourseFrontVo courseFrontVo) {
        Page<EduCourse> pageCourse = new Page<>(page,limit);
        Map<String,Object> map = courseService.getCourseFrontList(pageCourse,courseFrontVo);
        // 返回分页所有数据
        return R.ok().data(map);
    }

    //2 课程详情方法
    @GetMapping("getFrontCourseInfo/{courseId}")
    public R getFrontCourseInfo(@PathVariable String courseId) {
        // 根据课程id，编写sql语句查询课程
        CourseWebVo courseWebVo = courseService.getBaseCourseInfo(courseId);

        // 根据课程id查询章节和小节
        List<ChapterVo> chapterVideoList = chapterService.getChapterVideoByCourseId(courseId);

        return R.ok().data("courseWebVo",courseWebVo).data("chapterVideoList",chapterVideoList);
    }
}
