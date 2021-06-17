package com.vdcompany.adminSmartbox.service;

import com.vdcompany.adminSmartbox.bean.policy.PolicyVO;
import com.vdcompany.adminSmartbox.mapper.PolicyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    PolicyMapper policyMapper;

    @Override
    public List<PolicyVO> getPolicyList(PolicyVO policy) {
        return policyMapper.getPolicyList(policy);
    }
    @Override
    public int postPolicyList(PolicyVO policy) {
        return policyMapper.postPolicyList(policy);
    }
}
