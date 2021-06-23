package com.vdcompany.adminSmartbox.service;

import java.util.List;

import com.vdcompany.adminSmartbox.bean.goods.GoodsVO;
import com.vdcompany.adminSmartbox.bean.web.paging.PagingVO;

public interface GoodsService {

	List<GoodsVO> getGoodsList(PagingVO pagingVO);
	List<GoodsVO> postGoodsList(GoodsVO goodsVO);
	int updateGoodsImage(GoodsVO goodsVO);
}
