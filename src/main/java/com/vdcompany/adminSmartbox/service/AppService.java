package com.vdcompany.adminSmartbox.service;

import com.vdcompany.adminSmartbox.bean.app.AppVO;

import java.util.List;

public interface AppService {

//    int putTutorial(AppVO app);
    int postTutorialList(List<AppVO> app);

    List<AppVO> getPolicyList(AppVO app);
    int postPolicyList(AppVO app);

    List<AppVO> getAppVersionList();
    int postAppVersionList(AppVO app);

    List<AppVO> getAppAuthList();
    int postAppAuthList(AppVO app);

    List<AppVO> getRefundList();
    int postRefund(AppVO app);

    List<AppVO> getPaymentList();
    int postPayment(AppVO app);

}
