package com.vdcompany.adminSmartbox.service;

import com.vdcompany.adminSmartbox.bean.lookup.LookupVO;
import com.vdcompany.adminSmartbox.mapper.LookupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LookupServiceImpl implements LookupService {

	@Autowired
	LookupMapper lookupMapper;

	@Override
	public List<LookupVO> getLookupAgency() {
		// TODO Auto-generated method stub
		return lookupMapper.getLookupAgency();
	}

	@Override
	public List<LookupVO> getLookupStoreInfo() {
		// TODO Auto-generated method stub
		return lookupMapper.getLookupStoreInfo();
	}
	
}

