package com.vdcompany.adminSmartbox.service;

import java.util.List;

import com.vdcompany.adminSmartbox.bean.goods.GoodsVO;
import com.vdcompany.adminSmartbox.bean.web.paging.PagingVO;

public interface GoodsService {

	List<GoodsVO> getGoodsList(PagingVO pagingVO);
	List<GoodsVO> postGoodsList(GoodsVO goodsVO);
	List<GoodsVO> putGoodsList(GoodsVO goodsVO);
	int delGoodsList(GoodsVO goodsVO);

	List<GoodsVO> getGoodsDetailList(PagingVO pagingVO);

	List<GoodsVO> postGoodsBoxPrice(GoodsVO goodsVO);
	List<GoodsVO> putGoodsBoxPrice(GoodsVO goodsVO);
	int delGoodsBoxPrice(GoodsVO goodsVO);

	List<GoodsVO> postGoodsStorePrice(GoodsVO goodsVO);
	List<GoodsVO> putGoodsStorePrice(GoodsVO goodsVO);
	int delGoodsStorePrice(GoodsVO goodsVO);

	List<GoodsVO> postGoodsAgencyPrice(GoodsVO goodsVO);
	List<GoodsVO> putGoodsAgencyPrice(GoodsVO goodsVO);
	int delGoodsAgencyPrice(GoodsVO goodsVO);
}
