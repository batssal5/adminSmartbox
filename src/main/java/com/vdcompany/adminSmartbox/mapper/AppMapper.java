package com.vdcompany.adminSmartbox.mapper;

import com.vdcompany.adminSmartbox.bean.app.AppVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppMapper {

//    int putTutorial(AppVO app);
    int postTutorialList(List<AppVO> appList);

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
