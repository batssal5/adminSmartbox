package com.vdcompany.adminSmartbox.mapper;

import java.util.List;
import java.util.Map;

import com.vdcompany.adminSmartbox.bean.web.paging.PagingVO;
import org.apache.ibatis.annotations.Mapper;

import com.vdcompany.adminSmartbox.bean.AdminVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;

@Mapper
public interface AgencyMapper {
	
	AgencyVO getAgencyDetail(int idx);
	List<AgencyVO> getAgencyList();		// 본사 리스트
	List<AgencyVO> getAgencyInfo(PagingVO pagingVO);
	int postAgencyInfo(AgencyVO agencyVO);
	int putAgencyInfo(AgencyVO agencyVO);
	int delAgencyInfo(AgencyVO agencyVO);
	
	int insertAgency(AgencyVO agency);
	int updateAgency(AgencyVO agency);
}
