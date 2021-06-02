package com.vdcompany.adminSmartbox.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vdcompany.adminSmartbox.bean.AdminVO;
import com.vdcompany.adminSmartbox.bean.BrandVO;
import com.vdcompany.adminSmartbox.bean.CategoryVO;

@Mapper
public interface CategoryMapper {
	
	List<CategoryVO> getCateList(String code);		// code에 해당하는 카테고리 리스트
	List<BrandVO> getBrandList();		

}
