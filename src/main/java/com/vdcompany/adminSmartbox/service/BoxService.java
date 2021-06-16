package com.vdcompany.adminSmartbox.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vdcompany.adminSmartbox.bean.AdminVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencySearchVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyStoreVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;
import com.vdcompany.adminSmartbox.bean.box.BoxUpdateLogVO;
import com.vdcompany.adminSmartbox.bean.box.BoxVO;
import com.vdcompany.adminSmartbox.bean.goods.GoodsVO;
import com.vdcompany.adminSmartbox.bean.web.paging.PagingVO;

public interface BoxService {
	
	BoxVO getBoxDetail(int idx);
	
	List<BoxVO> getBoxList(PagingVO pagingVO);		// 박스 리스트
	int putBox(BoxVO boxVO);		// 박스 리스트
	int postBox(Map<String, String> map);						// 박스 정보 수정


	List<BoxVO> getBoxSearchList(BoxVO search);		// 박스 리스트
	List<BoxUpdateLogVO> getBoxUpdateLogList(int box_idx);	// 박스 idx에 해당하는 로그데이터 가져오기
	
	int insertBox(BoxVO box);	// 추가하기
	int updateBox(BoxVO box);	// 수정하기
	
	
}
