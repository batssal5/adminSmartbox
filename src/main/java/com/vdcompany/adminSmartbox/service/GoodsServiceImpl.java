package com.vdcompany.adminSmartbox.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdcompany.adminSmartbox.bean.AdminVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencySearchVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyStoreVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;
import com.vdcompany.adminSmartbox.bean.goods.GoodsAgencyVO;
import com.vdcompany.adminSmartbox.bean.goods.GoodsDisplayVO;
import com.vdcompany.adminSmartbox.bean.goods.GoodsVO;
import com.vdcompany.adminSmartbox.mapper.AdminMapper;
import com.vdcompany.adminSmartbox.mapper.AgencyMapper;
import com.vdcompany.adminSmartbox.mapper.AgencyStoreMapper;
import com.vdcompany.adminSmartbox.mapper.GoodsMapper;


@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	AgencyMapper agencyMapper;

	@Override
	public List<GoodsVO> getGoodsList() {
		return goodsMapper.getGoodsList();
	}


	@Override
	public List<GoodsVO> getSearchGoodsList(GoodsVO search) {
		// TODO Auto-generated method stub
		
		return goodsMapper.getSearchGoodsList(search);

	}


	@Override
	public int insertGoods(GoodsVO goods) {
		// TODO Auto-generated method stub
		return goodsMapper.insertGoods(goods);
	}


	@Override
	public int updateGoods(GoodsVO goods) {
		// TODO Auto-generated method stub
		return goodsMapper.updateGoods(goods);
	}


	@Override
	public GoodsVO getGoodsDetail(int idx) {
		// TODO Auto-generated method stub
		return goodsMapper.getGoodsDetail(idx);
	}


	@Override
	public List<GoodsDisplayVO> getGoodsDisplay(GoodsVO search, int agency_idx) {
		// TODO Auto-generated method stub
		
		List<AgencyVO> agencyList = agencyMapper.getAgencyList();
		
		List<GoodsVO> goodsList = goodsMapper.getSearchGoodsList(search);//goodsMapper.getGoodsList();
		System.out.println("displayList Search ret : " +goodsList);

		List<GoodsDisplayVO> displayList = new ArrayList<GoodsDisplayVO>();
		
		
		for(int i = 0 ; i < goodsList.size() ; i++) {
			GoodsVO goods = goodsList.get(i);
			
			GoodsDisplayVO display = new GoodsDisplayVO();
			display.setGoods(goods);
			
			List<GoodsAgencyVO> goodsAgencyList = goodsMapper.getGoodsDisplay(goods.getIdx());

			for( int k = 0 ; k < agencyList.size() ; k++) {

				AgencyVO subAgency = agencyList.get(k);
				
				
				boolean isMatch = false;
				for( int j = 0 ; j < goodsAgencyList.size() ; j++) {
					GoodsAgencyVO subGoodsAgency = goodsAgencyList.get(j);
					
					if(subAgency.getCompany_name().equals(subGoodsAgency.getCompany_name())) {
						isMatch = true;
						
						if(agency_idx != 0 && agency_idx == Integer.parseInt(subGoodsAgency.getIdx()))  {
							display.getAgency().add(subGoodsAgency);
						} else if (agency_idx == 0) {
							display.getAgency().add(subGoodsAgency);
						}
					}
				}
				
				if (isMatch == false) {
					GoodsAgencyVO goodsAgency = new GoodsAgencyVO();
					goodsAgency.setUsed("0");
					goodsAgency.setCompany_name(subAgency.getCompany_name());
					goodsAgency.setCompany_num(subAgency.getCompany_num());
					goodsAgency.setGds_idx(""+goods.getIdx());
					goodsAgency.setAgency_idx(""+subAgency.getIdx());
					
					if(agency_idx != 0 && agency_idx == subAgency.getIdx())  {
						display.getAgency().add(goodsAgency);
					} else if (agency_idx == 0) {
						display.getAgency().add(goodsAgency);
					}
				}
			}
			
			displayList.add(display);
		}
		
		return displayList;
	}


	@Override
	public int insertGoodsDisplay(GoodsAgencyVO goodsAgency) {

		return goodsMapper.insertGoodsDisplay(goodsAgency);
	}
	
}

