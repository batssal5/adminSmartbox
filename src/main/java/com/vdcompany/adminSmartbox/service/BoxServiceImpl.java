package com.vdcompany.adminSmartbox.service;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.vdcompany.adminSmartbox.bean.box.InventoryVO;
import com.vdcompany.adminSmartbox.bean.web.paging.PagingVO;
import com.vdcompany.adminSmartbox.mapper.*;
import com.vdcompany.adminSmartbox.utils.LoggingLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdcompany.adminSmartbox.bean.box.BoxVO;



@Service
public class BoxServiceImpl implements BoxService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BoxMapper boxMapper;
	@Autowired
	AgencyStoreMapper agencyStoreMapper;
	@Autowired
	LogMapper logMapper;
	@Autowired
	InventoryMapper inventoryMapper;


	@Override
	public List<BoxVO> getBoxList(PagingVO pagingVO) {
		// TODO Auto-generated method stub
		return boxMapper.getBoxList(pagingVO);
	}

	@Override
	public int postBox(Map<String, Object> map) {
		// TODO Auto-generated method stub
		logger.info(LoggingLine.LOG_CONTS_LINE);
		PagingVO pagingVO = new PagingVO();
		pagingVO.setBox_id(map.get("key").toString());
		List<BoxVO> boxVOList = boxMapper.getBoxList(pagingVO);
		logger.info("boxVOList:"+new Gson().toJson(boxVOList));

		int ret = boxMapper.postBox(map);
		logger.info("[DB-RESULT][update]sb_box : "+ret);
		if(ret < 1) {
			return ret;
		}
		if(!boxVOList.isEmpty()) {
			logger.info("[KEY][update]sb_box_info : " +boxVOList.get(0).getBox_idx());
			map.put("box_idx",boxVOList.get(0).getBox_idx());
			ret = boxMapper.postBoxInfo(map);
			logger.info("[DB-RESULT][update]sb_box_info : "+ret);
			logger.info("[KEY][update]agency_store : " +boxVOList.get(0).getStore_num());
			map.put("store_num",boxVOList.get(0).getStore_num());
			ret = agencyStoreMapper.postAgencyStore(map);
			logger.info("[DB-RESULT][update]agency_store : "+ret);
		}
		logger.info(LoggingLine.LOG_CONTE_LINE);
		return ret;
	}

	@Override
	public int putBox(BoxVO boxVO) {
		logger.info(LoggingLine.LOG_CONTS_LINE);
		// TODO Auto-generated method stub
		int ret = boxMapper.putBox(boxVO);
		logger.info("[DB-RESULT][insert]sb_box : "+ret);
		logger.info("[KEY][insert]sb_box_info : " +boxVO.getBox_idx());
		if(ret < 1) {
			return ret;
		}
		ret = boxMapper.putBoxInfo(boxVO);
		logger.info("[DB-RESULT][insert]sb_box_info : "+ret);
		logger.info(LoggingLine.LOG_CONTE_LINE);
		return ret;
	}

	@Override
	public int deleteBox(Map<String, Object> map) {
		// TODO Auto-generated method stub
		PagingVO pagingVO = new PagingVO();
		pagingVO.setBox_id(map.get("box_id").toString());
		//삭제 전 기본 정보 호출하여 취득
		List<BoxVO> boxVOList = boxMapper.getBoxList(pagingVO);
		logger.info(LoggingLine.LOG_CONTS_LINE);
		logger.info("boxVOList:"+new Gson().toJson(boxVOList));
		logger.info("[KEY][delete]sb_box_info : " +boxVOList.get(0).getBox_idx());
		map.put("box_idx",boxVOList.get(0).getBox_idx());
		int ret = boxMapper.deleteBoxInfo(map);
		logger.info("[DB-RESULT][delete]sb_box_info : "+ret);
		if(ret < 1) {
			return ret;
		}
		if(!boxVOList.isEmpty()) {
			ret = boxMapper.deleteBox(map);
			logger.info("[DB-RESULT][delete]sb_box : "+ret);
		}
		logger.info(LoggingLine.LOG_CONTE_LINE);
		return ret;
	}


	@Override
	public List<InventoryVO> getInventoryInfo(PagingVO pagingVO) {
		return inventoryMapper.getInventoryInfo(pagingVO);
	}

	@Override
	public List<InventoryVO> getInventoryDetailInfo(PagingVO pagingVO) {
		return inventoryMapper.getInventoryDetailInfo(pagingVO);
	}




	
}

