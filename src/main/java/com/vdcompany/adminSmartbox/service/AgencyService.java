package com.vdcompany.adminSmartbox.service;

import java.util.List; 
import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;
import com.vdcompany.adminSmartbox.bean.web.paging.PagingVO;

public interface AgencyService {
	List<AgencyVO> getAgencyInfo(PagingVO pagingVO);
	List<AgencyVO> postAgencyInfo(AgencyVO agencyVO);
	List<AgencyVO> putAgencyInfo(AgencyVO agencyVO);
	int delAgencyInfo(AgencyVO agencyVO);

	List<AgencyVO> getAgencyStoreInfo(PagingVO pagingVO);
	List<AgencyVO> postAgencyStoreInfo(AgencyVO agencyVO);
	List<AgencyVO> putAgencyStoreInfo(AgencyVO agencyVO);
	int delAgencyStoreInfo(AgencyVO agencyVO);

	
}
