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
	public List<GoodsVO> putGoodsList(GoodsVO goodsVO) {
		int ret = goodsMapper.putGoodsList(goodsVO);
		List<GoodsVO> rtn = new ArrayList<>();
		if(ret>-1){
			PagingVO pagingVO = new PagingVO();
			pagingVO.setIdx(String.valueOf(goodsVO.getIdx()));
			rtn = goodsMapper.getGoodsList(pagingVO);
		}

		return rtn;
	}

	@Override
	public int delGoodsList(GoodsVO goodsVO) {
		int ret = goodsMapper.delGoodsList(goodsVO);
		return ret;
	}
	@Override
	public List<GoodsVO> getGoodsDetailList(PagingVO pagingVO) {
		return goodsMapper.getGoodsDetailList(pagingVO);
	}

	@Override
	public List<GoodsVO> postGoodsBoxPrice(GoodsVO goodsVO) {
		int ret = goodsMapper.postGoodsBoxPrice(goodsVO);
		List<GoodsVO> rtn = new ArrayList<>();
		if(ret>-1){
			PagingVO pagingVO = new PagingVO();
			pagingVO.setGoods_idx(goodsVO.getGoods_idx());
			pagingVO.setAgency_idx(goodsVO.getAgency_idx());
			pagingVO.setBox_idx(goodsVO.getBox_idx());
			pagingVO.setAgc_sto_idx(goodsVO.getAgc_sto_idx());
			rtn = goodsMapper.getGoodsDetailList(pagingVO);
		}

		return rtn;
	}

	@Override
	public List<GoodsVO> putGoodsBoxPrice(GoodsVO goodsVO) {
		int ret = goodsMapper.putGoodsBoxPrice(goodsVO);
		List<GoodsVO> rtn = new ArrayList<>();
		if(ret>-1){
			PagingVO pagingVO = new PagingVO();
			pagingVO.setGoods_idx(goodsVO.getGoods_idx());
			pagingVO.setAgency_idx(goodsVO.getAgency_idx());
			pagingVO.setBox_idx(goodsVO.getBox_idx());
			pagingVO.setAgc_sto_idx(goodsVO.getAgc_sto_idx());
			rtn = goodsMapper.getGoodsList(pagingVO);
		}

		return rtn;
	}

	@Override
	public int delGoodsBoxPrice(GoodsVO goodsVO) {
		int ret = goodsMapper.delGoodsBoxPrice(goodsVO);
		return ret;
	}

	@Override
	public List<GoodsVO> postGoodsStorePrice(GoodsVO goodsVO) {
		int ret = goodsMapper.postGoodsStorePrice(goodsVO);
		List<GoodsVO> rtn = new ArrayList<>();
		if(ret>-1){
			PagingVO pagingVO = new PagingVO();
			pagingVO.setGoods_idx(goodsVO.getGoods_idx());
			pagingVO.setAgency_idx(goodsVO.getAgency_idx());
			pagingVO.setBox_idx(goodsVO.getBox_idx());
			pagingVO.setAgc_sto_idx(goodsVO.getAgc_sto_idx());
			rtn = goodsMapper.getGoodsDetailList(pagingVO);
		}

		return rtn;
	}

	@Override
	public List<GoodsVO> putGoodsStorePrice(GoodsVO goodsVO) {
		int ret = goodsMapper.putGoodsStorePrice(goodsVO);
		List<GoodsVO> rtn = new ArrayList<>();
		if(ret>-1){
			PagingVO pagingVO = new PagingVO();
			pagingVO.setGoods_idx(goodsVO.getGoods_idx());
			pagingVO.setAgency_idx(goodsVO.getAgency_idx());
			pagingVO.setBox_idx(goodsVO.getBox_idx());
			pagingVO.setAgc_sto_idx(goodsVO.getAgc_sto_idx());
			rtn = goodsMapper.getGoodsList(pagingVO);
		}

		return rtn;
	}

	@Override
	public int delGoodsStorePrice(GoodsVO goodsVO) {
		int ret = goodsMapper.delGoodsStorePrice(goodsVO);
		return ret;
	}

	@Override
	public List<GoodsVO> postGoodsAgencyPrice(GoodsVO goodsVO) {
		int ret = goodsMapper.postGoodsAgencyPrice(goodsVO);
		List<GoodsVO> rtn = new ArrayList<>();
		if(ret>-1){
			PagingVO pagingVO = new PagingVO();
			pagingVO.setGoods_idx(goodsVO.getGoods_idx());
			pagingVO.setAgency_idx(goodsVO.getAgency_idx());
			pagingVO.setBox_idx(goodsVO.getBox_idx());
			pagingVO.setAgc_sto_idx(goodsVO.getAgc_sto_idx());
			rtn = goodsMapper.getGoodsDetailList(pagingVO);
		}

		return rtn;
	}

	@Override
	public List<GoodsVO> putGoodsAgencyPrice(GoodsVO goodsVO) {
		int ret = goodsMapper.putGoodsAgencyPrice(goodsVO);
		List<GoodsVO> rtn = new ArrayList<>();
		if(ret>-1){
			PagingVO pagingVO = new PagingVO();
			pagingVO.setGoods_idx(goodsVO.getGoods_idx());
			pagingVO.setAgency_idx(goodsVO.getAgency_idx());
			pagingVO.setBox_idx(goodsVO.getBox_idx());
			pagingVO.setAgc_sto_idx(goodsVO.getAgc_sto_idx());
			rtn = goodsMapper.getGoodsList(pagingVO);
		}

		return rtn;
	}

	@Override
	public int delGoodsAgencyPrice(GoodsVO goodsVO) {
		int ret = goodsMapper.delGoodsAgencyPrice(goodsVO);
		return ret;
	}
}

