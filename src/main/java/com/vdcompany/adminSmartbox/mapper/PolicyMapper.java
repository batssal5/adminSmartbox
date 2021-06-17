package com.vdcompany.adminSmartbox.mapper;

import com.vdcompany.adminSmartbox.bean.policy.PolicyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.ArrayList;

@Mapper
public interface PolicyMapper {

    List<PolicyVO> getPolicyList(PolicyVO policy);
    int postPolicyList(PolicyVO policy);

}
