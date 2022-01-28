package com.akasaka.educms.service;

import com.akasaka.educms.entity.CrmBanner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author akasaka
 * @since 2021-11-08
 */
public interface CrmBannerService extends IService<CrmBanner> {

    // 查询所有banner
    List<CrmBanner> selectAllBanner();
}
