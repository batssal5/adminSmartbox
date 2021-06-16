package com.vdcompany.adminSmartbox.service;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.vdcompany.adminSmartbox.bean.web.paging.PagingVO;
import com.vdcompany.adminSmartbox.mapper.AgencyMapper;
import com.vdcompany.adminSmartbox.mapper.AgencyStoreMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdcompany.adminSmartbox.bean.box.BoxUpdateLogVO;
import com.vdcompany.adminSmartbox.bean.box.BoxVO;
import com.vdcompany.adminSmartbox.mapper.BoxMapper;
import com.vdcompany.adminSmartbox.mapper.LogMapper;


@Service
public class BoxServiceImpl implements BoxService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BoxMapper boxMapper;
	@Autowired
	AgencyStoreMapper agencyStoreMapper;
	@Autowired
	LogMapper logMapper;

	@Override
	public List<BoxVO> getBoxList(PagingVO pagingVO) {
		// TODO Auto-generated method stub
		return boxMapper.getBoxList(pagingVO);
	}

	@Override
	public int postBox(Map<String, String> map) {
		// TODO Auto-generated method stub
		PagingVO pagingVO = new PagingVO();
		pagingVO.setBox_id(map.get("key"));
		List<BoxVO> boxVOList = boxMapper.getBoxList(pagingVO);
		logger.info("boxVOList:"+new Gson().toJson(boxVOList));
		//BoxVO detail = getBoxDetail(Integer.parseInt(map.get("key")));

		int ret = boxMapper.postBox(map);
		System.out.println("updateBox ret : " +ret);
		if(ret < 1) {
			return ret;
		}
		if(!boxVOList.isEmpty()) {
			System.out.println("boxVOList.get(0).getBox_idx() : " +boxVOList.get(0).getBox_idx());
			map.put("box_idx",boxVOList.get(0).getBox_idx());
			ret = boxMapper.postBoxInfo(map);
			map.put("store_num",boxVOList.get(0).getStore_num());
			ret = agencyStoreMapper.postAgencyStore(map);
		}
		System.out.println("updateBoxInfo ret : " +ret);
		if(ret > 0) {

		}
		return ret;
	}

	@Override
	public int putBox(BoxVO boxVO) {
		// TODO Auto-generated method stub
		return boxMapper.putBox(boxVO);
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

