package com.vdcompany.adminSmartbox.service;

import java.util.ArrayList;
import java.util.List;

import com.vdcompany.adminSmartbox.bean.web.paging.PagingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;
import com.vdcompany.adminSmartbox.mapper.AgencyMapper;
import com.vdcompany.adminSmartbox.mapper.AgencyStoreMapper;


@Service
public class AgencyServiceImpl implements AgencyService {

	@Autowired
	AgencyMapper agencyMapper;
	@Autowired
	AgencyStoreMapper storeMapper;

	@Override
	public List<AgencyVO> getAgencyInfo(PagingVO pagingVO) {
		return agencyMapper.getAgencyInfo(pagingVO);
	}


	@Override
	public List<AgencyVO> postAgencyInfo(AgencyVO agencyVO) {
		int ret = agencyMapper.postAgencyInfo(agencyVO);
		List<AgencyVO> rtn = new ArrayList<>();
		if(ret>-1){
			PagingVO pagingVO = new PagingVO();
			pagingVO.setIdx(String.valueOf(agencyVO.getIdx()));
			rtn = agencyMapper.getAgencyInfo(pagingVO);
		}

		return rtn;
	}


	@Override
	public List<AgencyVO> putAgencyInfo(AgencyVO agencyVO) {
		int ret = agencyMapper.putAgencyInfo(agencyVO);
		List<AgencyVO> rtn = new ArrayList<>();
		if(ret>-1){
			PagingVO pagingVO = new PagingVO();
			pagingVO.setIdx(String.valueOf(agencyVO.getIdx()));
			rtn = agencyMapper.getAgencyInfo(pagingVO);
		}

		return rtn;
	}


	@Override
	public int delAgencyInfo(AgencyVO agencyVO) {
		int ret = agencyMapper.delAgencyInfo(agencyVO);
		return ret;
	}



	@Override
	public List<AgencyVO> getAgencyStoreInfo(PagingVO pagingVO) {
		return storeMapper.getAgencyStoreInfo(pagingVO);
	}

	@Override
	public List<AgencyVO> postAgencyStoreInfo(AgencyVO agencyVO) {
		int ret = storeMapper.postAgencyStoreInfo(agencyVO);
		List<AgencyVO> rtn = new ArrayList<>();
		if(ret>-1){
			PagingVO pagingVO = new PagingVO();
			pagingVO.setStore_idx(String.valueOf(agencyVO.getStore_idx()));
			rtn = agencyMapper.getAgencyInfo(pagingVO);
		}

		return rtn;
	}


	@Override
	public List<AgencyVO> putAgencyStoreInfo(AgencyVO agencyVO) {
		int ret = storeMapper.putAgencyStoreInfo(agencyVO);
		List<AgencyVO> rtn = new ArrayList<>();
		if(ret>-1){
			PagingVO pagingVO = new PagingVO();
			pagingVO.setStore_idx(String.valueOf(agencyVO.getStore_idx()));
			rtn = agencyMapper.getAgencyInfo(pagingVO);
		}

		return rtn;
	}


	@Override
	public int delAgencyStoreInfo(AgencyVO agencyVO) {
		int ret = storeMapper.delAgencyStoreInfo(agencyVO);
		return ret;
	}
}

