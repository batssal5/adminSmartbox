package com.vdcompany.adminSmartbox.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vdcompany.adminSmartbox.bean.AdminVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;
import com.vdcompany.adminSmartbox.bean.box.BoxVO;
import com.vdcompany.adminSmartbox.bean.goods.GoodsVO;

@Mapper
public interface BoxMapper {

	BoxVO getBoxDetail(int idx);

	List<BoxVO> getBoxList();		// 박스 리스트
	List<BoxVO> getBoxSearchList(BoxVO search);		// 박스 리스트

	int insertBox(BoxVO box);	// 추가하기
	int insertBoxInfo(BoxVO box);	// 추가하기
	
	int updateBox(BoxVO box);	// 수정하기
	int updateBoxInfo(BoxVO box);	// 수정하기

}
