package com.vdcompany.adminSmartbox.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vdcompany.adminSmartbox.bean.AdminVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;
import com.vdcompany.adminSmartbox.bean.goods.GoodsAgencyVO;
import com.vdcompany.adminSmartbox.bean.goods.GoodsDisplayVO;
import com.vdcompany.adminSmartbox.bean.goods.GoodsVO;

@Mapper
public interface GoodsMapper {

	GoodsVO getGoodsDetail(int idx);

	List<GoodsVO> getGoodsList();		// 상품 리스트
	List<GoodsVO> getSearchGoodsList(GoodsVO search);		// 상품 리스트
	List<GoodsAgencyVO> getGoodsDisplay(int gdsIdx);

	int insertGoods(GoodsVO goods);
	int updateGoods(GoodsVO goods);

	int insertGoodsDisplay(GoodsAgencyVO goodsAgency);
}
