package com.akasaka.staservice.service;

import com.akasaka.staservice.entity.StatisticsDaily;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 网站统计日数据 服务类
 * </p>
 *
 * @author akasaka
 * @since 2021-11-13
 */
public interface StatisticsDailyService extends IService<StatisticsDaily> {

    // 统计某一天注册人数,生成统计数据
    void registerCount(String day);

    // 图标显示，返回两部分数据，日期json数组，数量json数组
    Map<String, Object> getShowData(String type, String begin, String end);
}
