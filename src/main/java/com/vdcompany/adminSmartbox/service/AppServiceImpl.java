package com.vdcompany.adminSmartbox.service;

import com.vdcompany.adminSmartbox.bean.app.AppPolicyVO;
import com.vdcompany.adminSmartbox.bean.app.AppTutorialVO;
import com.vdcompany.adminSmartbox.mapper.AppMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {
    @Autowired
    AppMapper appMapper;

    @Override
    public int putTutorial(AppTutorialVO appTutorial) {
        return appMapper.putTutorial(appTutorial);
    }

    @Override
    public int postTutorialList(List<AppTutorialVO> appTutorial) {
        return appMapper.postTutorialList(appTutorial);
    }

    @Override
    public List<AppPolicyVO> getPolicyList(AppPolicyVO policy) {
        return appMapper.getPolicyList(policy);
    }
    @Override
    public int postPolicyList(AppPolicyVO policy) {
        return appMapper.postPolicyList(policy);
    }
}
