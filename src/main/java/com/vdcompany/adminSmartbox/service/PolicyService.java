package com.vdcompany.adminSmartbox.service;

import com.vdcompany.adminSmartbox.bean.policy.PolicyVO;

import java.util.List;
import java.util.ArrayList;

public interface PolicyService {

    List<PolicyVO> getPolicyList(PolicyVO policy);
    int postPolicyList(PolicyVO policy);

}
