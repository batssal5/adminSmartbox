package com.vdcompany.adminSmartbox.mapper;

import com.vdcompany.adminSmartbox.bean.app.AppPolicyVO;
import com.vdcompany.adminSmartbox.bean.app.AppTutorialVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppMapper {

    int putTutorial(AppTutorialVO appTutorial);
    int postTutorialList(List<AppTutorialVO> appTutorial);

    List<AppPolicyVO> getPolicyList(AppPolicyVO policy);
    int postPolicyList(AppPolicyVO policy);

}
