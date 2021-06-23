package com.vdcompany.adminSmartbox.service;

import java.util.ArrayList;
import java.util.List;

import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;
import com.vdcompany.adminSmartbox.bean.web.paging.PagingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdcompany.adminSmartbox.bean.goods.GoodsVO;
import com.vdcompany.adminSmartbox.mapper.AgencyMapper;
import com.vdcompany.adminSmartbox.mapper.GoodsMapper;


@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	AgencyMapper agencyMapper;

	@Override
	public List<GoodsVO> getGoodsList(PagingVO pagingVO) {
		return goodsMapper.getGoodsList(pagingVO);
	}
	@Override
	public List<GoodsVO> postGoodsList(GoodsVO goodsVO) {
		int ret = goodsMapper.postGoodsList(goodsVO);
		List<GoodsVO> rtn = new ArrayList<>();
		if(ret>-1){
			PagingVO pagingVO = new PagingVO();
			pagingVO.setIdx(String.valueOf(goodsVO.getIdx()));
			rtn = goodsMapper.getGoodsList(pagingVO);
		}

		return rtn;
	}
	@Override
	public int updateGoodsImage(GoodsVO goodsVO) {
		return goodsMapper.updateGoodsImage(goodsVO);
	}
	
}

