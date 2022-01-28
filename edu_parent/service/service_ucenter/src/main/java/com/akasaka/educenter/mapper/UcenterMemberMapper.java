package com.akasaka.educenter.mapper;

import com.akasaka.educenter.entity.UcenterMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author akasaka
 * @since 2021-11-10
 */
public interface UcenterMemberMapper extends BaseMapper<UcenterMember> {

    // 查询某一天注册人数
    Integer countRegisterDay(String day);
}
