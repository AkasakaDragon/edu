package com.akasaka.educenter.service;

import com.akasaka.educenter.entity.UcenterMember;
import com.akasaka.educenter.entity.vo.RegisterVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author akasaka
 * @since 2021-11-10
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    // 登录的方法
    String login(UcenterMember member);

    // 注册的方法
    void register(RegisterVo registerVo);

    // 根据openid判断
    UcenterMember getOpenIdMember(String openid);

    // 查询某一天注册人数
    Integer countRegisterDay(String day);
}
