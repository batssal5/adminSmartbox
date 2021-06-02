package com.vdcompany.adminSmartbox.service;

import java.util.List;

import com.vdcompany.adminSmartbox.bean.AdminVO;
import com.vdcompany.adminSmartbox.bean.BrandVO;
import com.vdcompany.adminSmartbox.bean.CategoryVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyStoreVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;

public interface CategoryService {
	
	List<CategoryVO> getCateList(String code);		
	List<BrandVO> getBrandList();		

}
