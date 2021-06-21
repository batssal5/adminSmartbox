package com.vdcompany.adminSmartbox.mapper;

import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;
import com.vdcompany.adminSmartbox.bean.box.InventoryVO;
import com.vdcompany.adminSmartbox.bean.web.paging.PagingVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InventoryMapper {
	
	AgencyVO getAgencyDetail(int idx);
	List<AgencyVO> getAgencyList();		// 본사 리스트
	List<AgencyVO> getAgencyInfo(PagingVO pagingVO);
	int postAgencyInfo(AgencyVO agencyVO);
	int putAgencyInfo(AgencyVO agencyVO);
	int delAgencyInfo(AgencyVO agencyVO);


	List<InventoryVO> getInventoryInfo(PagingVO pagingVO);
	int postInventoryInfo(InventoryVO inventoryVO);
	int putInventoryInfo(InventoryVO inventoryVO);
	int delInventoryInfo(InventoryVO inventoryVO);


	List<InventoryVO> getInventoryDetailInfo(PagingVO pagingVO);
	
	int insertAgency(AgencyVO agency);
	int updateAgency(AgencyVO agency);
}
