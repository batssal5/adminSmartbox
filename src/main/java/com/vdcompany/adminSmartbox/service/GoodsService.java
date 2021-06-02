package com.vdcompany.adminSmartbox.service;

import java.util.List;

import com.vdcompany.adminSmartbox.bean.AdminVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencySearchVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyStoreVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;
import com.vdcompany.adminSmartbox.bean.goods.GoodsAgencyVO;
import com.vdcompany.adminSmartbox.bean.goods.GoodsDisplayVO;
import com.vdcompany.adminSmartbox.bean.goods.GoodsVO;

public interface GoodsService {
	
	GoodsVO getGoodsDetail(int idx);
	List<GoodsVO> getGoodsList();		// 상품 리스트
	List<GoodsVO> getSearchGoodsList(GoodsVO search);
	List<GoodsDisplayVO> getGoodsDisplay(GoodsVO search, int agency_idx);
	
	int insertGoods(GoodsVO goods);
	int updateGoods(GoodsVO goods);
	int insertGoodsDisplay(GoodsAgencyVO goodsAgency);
}
