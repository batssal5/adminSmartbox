package com.vdcompany.adminSmartbox.mapper;

import java.util.List;

import com.vdcompany.adminSmartbox.bean.web.paging.PagingVO;
import org.apache.ibatis.annotations.Mapper;

import com.vdcompany.adminSmartbox.bean.goods.GoodsVO;

@Mapper
public interface GoodsMapper {


	List<GoodsVO> getGoodsList(PagingVO pagingVO);
	int postGoodsList(GoodsVO goodsVO);
	int updateGoodsImage(GoodsVO goodsVO);
}
