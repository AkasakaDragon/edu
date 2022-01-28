package com.akasaka.eduservice.client;

import com.akasaka.commonutils.UcenterMemberVo;
import com.akasaka.eduservice.client.impl.UcenterClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(name = "service-ucenter",fallback = UcenterClientImpl.class)
public interface UcenterClient {

    @PostMapping("/educenter/member/getMemberInfoById/{memberId}")
    public UcenterMemberVo getMemberInfoById(@PathVariable String memberId);

}

