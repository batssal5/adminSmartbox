package com.vdcompany.adminSmartbox.service;

import com.vdcompany.adminSmartbox.bean.app.AppPolicyVO;
import com.vdcompany.adminSmartbox.bean.app.AppTutorialVO;

import java.util.List;

public interface AppService {

    int putTutorial(AppTutorialVO appTutorial);
    int postTutorialList(List<AppTutorialVO> appTutorial);

    List<AppPolicyVO> getPolicyList(AppPolicyVO policy);
    int postPolicyList(AppPolicyVO policy);

}
