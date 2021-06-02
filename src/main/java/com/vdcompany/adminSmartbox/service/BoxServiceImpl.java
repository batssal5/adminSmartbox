package com.vdcompany.adminSmartbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdcompany.adminSmartbox.bean.AdminVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencySearchVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyStoreVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;
import com.vdcompany.adminSmartbox.bean.box.BoxUpdateLogVO;
import com.vdcompany.adminSmartbox.bean.box.BoxVO;
import com.vdcompany.adminSmartbox.bean.goods.GoodsVO;
import com.vdcompany.adminSmartbox.mapper.AdminMapper;
import com.vdcompany.adminSmartbox.mapper.AgencyMapper;
import com.vdcompany.adminSmartbox.mapper.AgencyStoreMapper;
import com.vdcompany.adminSmartbox.mapper.BoxMapper;
import com.vdcompany.adminSmartbox.mapper.GoodsMapper;
import com.vdcompany.adminSmartbox.mapper.LogMapper;


@Service
public class BoxServiceImpl implements BoxService {

	@Autowired
	BoxMapper boxMapper;
	@Autowired
	LogMapper logMapper;

	@Override
	public List<BoxVO> getBoxList() {
		// TODO Auto-generated method stub
		return boxMapper.getBoxList();
	}

	@Override
	public List<BoxVO> getBoxSearchList(BoxVO search) {
		// TODO Auto-generated method stub
		return boxMapper.getBoxSearchList(search);
	}

	@Override
	public int insertBox(BoxVO box) {
		// TODO Auto-generated method stub
		boxMapper.insertBox(box);	// insert후 box_idx가 VO에 자동으로 들어간다
		
		System.out.println("box.getBox_idx() : " +box.getBox_idx());
		if(Integer.parseInt(box.getBox_idx()) < 1) {
			return Integer.parseInt(box.getBox_idx());
		}
		
		int ret = boxMapper.insertBoxInfo(box);
		System.out.println("insertBox ret : " +ret);
		return ret;
	}

	@Override
	public BoxVO getBoxDetail(int idx) {
		// TODO Auto-generated method stub
		return boxMapper.getBoxDetail(idx);
	}

	@Override
	public int updateBox(BoxVO box) {
		
		BoxVO detail = getBoxDetail(Integer.parseInt(box.getBox_idx()));

		int ret = boxMapper.updateBox(box);	
		System.out.println("updateBox ret : " +ret);
		if(ret < 1) {
			return ret;
		}
		ret = boxMapper.updateBoxInfo(box);
		System.out.println("updateBoxInfo ret : " +ret);
		

		if(ret > 0) {
			// 기존 본사와 지점이 달라진경우 로그에 저장한다
			System.out.println("log : "+ detail.getAgc_idx() + " / " + box.getAgc_idx() + " / " + detail.getStore_idx() + " / " + box.getStore_idx());

			if(!detail.getAgc_idx().equals(box.getAgc_idx())
					|| !detail.getStore_idx().equals(box.getStore_idx())) {
				System.out.println("box update log add : ");
				

				logMapper.insertBoxUpdateLog(box);
			}
		}
		return ret;
	}

	@Override
	public List<BoxUpdateLogVO> getBoxUpdateLogList(int box_idx) {
		// TODO Auto-generated method stub
		return logMapper.getBoxUpdateLog(box_idx);
	}

	
}

