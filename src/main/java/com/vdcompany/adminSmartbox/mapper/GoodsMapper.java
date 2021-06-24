package com.vdcompany.adminSmartbox.mapper;

import java.util.List;

import com.vdcompany.adminSmartbox.bean.web.paging.PagingVO;
import org.apache.ibatis.annotations.Mapper;

import com.vdcompany.adminSmartbox.bean.goods.GoodsVO;

@Mapper
public interface GoodsMapper {


	List<GoodsVO> getGoodsList(PagingVO pagingVO);
	int postGoodsList(GoodsVO goodsVO);
	int putGoodsList(GoodsVO goodsVO);
	int delGoodsList(GoodsVO goodsVO);
	List<GoodsVO> getGoodsDetailList(PagingVO pagingVO);
	int postGoodsBoxPrice(GoodsVO goodsVO);
	int putGoodsBoxPrice(GoodsVO goodsVO);
	int delGoodsBoxPrice(GoodsVO goodsVO);

	int postGoodsStorePrice(GoodsVO goodsVO);
	int putGoodsStorePrice(GoodsVO goodsVO);
	int delGoodsStorePrice(GoodsVO goodsVO);

	int postGoodsAgencyPrice(GoodsVO goodsVO);
	int putGoodsAgencyPrice(GoodsVO goodsVO);
	int delGoodsAgencyPrice(GoodsVO goodsVO);
}
