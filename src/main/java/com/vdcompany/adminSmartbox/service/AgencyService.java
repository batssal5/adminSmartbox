package com.vdcompany.adminSmartbox.service;

import java.util.List;

import com.vdcompany.adminSmartbox.bean.AdminVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencySearchVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyStoreVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;

public interface AgencyService {
	
	AgencyVO getAgencyDetail(int idx);
	List<AgencyVO> getAgencyList();		// 본사 리스트
	List<AgencyStoreVO> getStoreList(int agencyIdx);		// 지점 리스트
	List<AgencyStoreVO> getSearchStoreList(AgencySearchVO search); 	// 조건으로 지점 검색하기
	
	int insertAgency(AgencyVO agency);	// 본사 추가하기
	int updateAgency(AgencyVO agency);	// 본사 추가하기
	int insertStoreList(List<AgencyStoreVO> list);	// 지점 추가하기
	int updateStoreList(List<AgencyStoreVO> list);	// 지점 업데이트하기
	
}
