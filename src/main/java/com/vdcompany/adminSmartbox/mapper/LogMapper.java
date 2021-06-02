package com.vdcompany.adminSmartbox.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vdcompany.adminSmartbox.bean.AdminVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;
import com.vdcompany.adminSmartbox.bean.box.BoxUpdateLogVO;
import com.vdcompany.adminSmartbox.bean.box.BoxVO;
import com.vdcompany.adminSmartbox.bean.goods.GoodsVO;

@Mapper
public interface LogMapper {

	int insertBoxUpdateLog(BoxVO box);	// 박스 수정할경우 로그저장
	
	List<BoxUpdateLogVO> getBoxUpdateLog(int box_idx); // 박스아이디에 해당하는 로그데이터 가져오기 
	
}
