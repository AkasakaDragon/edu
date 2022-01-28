package com.akasaka.educms.controller;


import com.akasaka.commonutils.R;
import com.akasaka.educms.entity.CrmBanner;
import com.akasaka.educms.service.CrmBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 首页banner显示
 * </p>
 *
 * @author akasaka
 * @since 2021-11-08
 */
@RestController
@RequestMapping("/educms/bannerfront")
public class BannerFrontController {

    @Autowired
    private CrmBannerService bannerService;

    // 查询所有banner
    @GetMapping("getAllBanner")
    public R getAllBanner() {
        List<CrmBanner> list = bannerService.selectAllBanner();
        return R.ok().data("list",list);
    }

}

