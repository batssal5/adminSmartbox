package com.vdcompany.adminSmartbox.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.vdcompany.adminSmartbox.bean.AdminVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencySearchVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyStoreVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;

@Mapper
public interface AgencyStoreMapper {
	
	List<AgencyStoreVO> getStoreList(int agency_idx);		// 지점 리스트
	List<AgencyStoreVO> getSearchStoreList(AgencySearchVO search);
	
	int insertStoreList(List<AgencyStoreVO> list);
	int updateStoreList(List<AgencyStoreVO> list);
	int postAgencyStore(Map<String, String> map);
}
