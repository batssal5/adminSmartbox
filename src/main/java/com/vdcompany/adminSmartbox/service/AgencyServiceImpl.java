package com.vdcompany.adminSmartbox.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdcompany.adminSmartbox.bean.AdminVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencySearchVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyStoreVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;
import com.vdcompany.adminSmartbox.mapper.AdminMapper;
import com.vdcompany.adminSmartbox.mapper.AgencyMapper;
import com.vdcompany.adminSmartbox.mapper.AgencyStoreMapper;


@Service
public class AgencyServiceImpl implements AgencyService {

	@Autowired
	AgencyMapper agencyMapper;
	@Autowired
	AgencyStoreMapper storeMapper;
	
	@Override
	public AgencyVO getAgencyDetail(int idx) {
		return agencyMapper.getAgencyDetail(idx);
	}

	@Override
	public List<AgencyVO> getAgencyList() {
		return agencyMapper.getAgencyList();
	}
	
	@Override
	public List<AgencyStoreVO> getStoreList(int agency_idx) {
		return storeMapper.getStoreList(agency_idx);
	}

	
	@Override
	public List<AgencyStoreVO> getSearchStoreList(AgencySearchVO search) {
		return storeMapper.getSearchStoreList(search);
	}

	@Override
	public int insertAgency(AgencyVO agency) {
		
		agencyMapper.insertAgency(agency);
		
		System.out.println("agc_idx : " +agency.getIdx());

		return agency.getIdx();
	}

	@Override
	public int updateAgency(AgencyVO agency) {
		
		agencyMapper.updateAgency(agency);
		
		System.out.println("agc_idx : " +agency.getIdx());

		return agency.getIdx();
	}

	@Override
	public int insertStoreList(List<AgencyStoreVO> list) {
		
		int ret = storeMapper.insertStoreList(list);

		if(list.size() > 0) {
			System.out.println("store_idx : " + list.get(0).getIdx());
			return list.get(0).getIdx();
		} else {
			System.out.println("store_idx : " + ret);
			return ret;
		}
	}

	@Override
	public int updateStoreList(List<AgencyStoreVO> list) {
		System.out.println("storeMapper.updateStoreList");
		int ret = storeMapper.updateStoreList(list);
		System.out.println("storeMapper.updateStoreList");

		if(list.size() > 0) {
			System.out.println("store_idx : " + list.get(0).getIdx());
			return list.get(0).getIdx();
		} else {
			System.out.println("store_idx : " + ret);
			return ret;
		}
	}
	@Override
	public int postAgencyStore(Map<String, String> map) {
		System.out.println("storeMapper.postAgencyStore");
		int ret = storeMapper.postAgencyStore(map);

		System.out.println("postAgencyStore  ret: " + ret);
		return ret;
	}
}

