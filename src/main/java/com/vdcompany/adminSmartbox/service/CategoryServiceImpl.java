package com.vdcompany.adminSmartbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdcompany.adminSmartbox.bean.AdminVO;
import com.vdcompany.adminSmartbox.bean.BrandVO;
import com.vdcompany.adminSmartbox.bean.CategoryVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyStoreVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;
import com.vdcompany.adminSmartbox.mapper.AdminMapper;
import com.vdcompany.adminSmartbox.mapper.AgencyMapper;
import com.vdcompany.adminSmartbox.mapper.AgencyStoreMapper;
import com.vdcompany.adminSmartbox.mapper.CategoryMapper;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryMapper cateMapper;

	@Override
	public List<CategoryVO> getCateList(String code) {

		return cateMapper.getCateList(code);
	}

	@Override
	public List<BrandVO> getBrandList() {
		// TODO Auto-generated method stub
		return cateMapper.getBrandList();
	}
	
}
