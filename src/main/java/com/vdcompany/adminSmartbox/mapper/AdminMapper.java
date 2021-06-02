package com.vdcompany.adminSmartbox.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vdcompany.adminSmartbox.bean.AdminVO;

@Mapper
public interface AdminMapper {
	
	List<AdminVO> getAdminList();		// 관리자 리스트
}
