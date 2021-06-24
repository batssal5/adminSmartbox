package com.vdcompany.adminSmartbox.service;

import com.vdcompany.adminSmartbox.bean.app.AppVO;
import com.vdcompany.adminSmartbox.mapper.AppMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {
    @Autowired
    AppMapper appMapper;

//    @Override
//    public int putTutorial(AppVO app) {
//        return appMapper.putTutorial(app);
//    }

    @Override
    public int postTutorialList(List<AppVO> app) {
        return appMapper.postTutorialList(app);
    }

    @Override
    public List<AppVO> getPolicyList(AppVO app) {
        return appMapper.getPolicyList(app);
    }

    @Override
    public int postPolicyList(AppVO app) {
        return appMapper.postPolicyList(app);
    }

    @Override
    public List<AppVO> getAppVersionList() {
        return appMapper.getAppVersionList();
    }

    @Override
    public int postAppVersionList(AppVO app) {
        return appMapper.postAppVersionList(app);
    }

    @Override
    public List<AppVO> getAppAuthList() {
        return appMapper.getAppAuthList();
    }

    @Override
    public int postAppAuthList(AppVO app) {
        return appMapper.postAppAuthList(app);
    }

    @Override
    public List<AppVO> getRefundList() {
        return appMapper.getRefundList();
    }

    @Override
    public int postRefund(AppVO app) {
        return appMapper.postRefund(app);
    }

    @Override
    public List<AppVO> getPaymentList() {
        return appMapper.getPaymentList();
    }

    @Override
    public int postPayment(AppVO app) {
        return appMapper.postPayment(app);
    }
}
