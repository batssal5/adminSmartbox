package com.vdcompany.adminSmartbox.service;

import com.vdcompany.adminSmartbox.bean.box.BoxUpdateLogVO;
import com.vdcompany.adminSmartbox.bean.box.BoxVO;
import com.vdcompany.adminSmartbox.bean.home.PaymentPerDayVO;
import com.vdcompany.adminSmartbox.mapper.BoxMapper;
import com.vdcompany.adminSmartbox.mapper.HomeMapper;
import com.vdcompany.adminSmartbox.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	HomeMapper homeMapper;
	@Autowired
	LogMapper logMapper;

	@Override
	public List<PaymentPerDayVO> getPaymentInfoPerDay() {
		// TODO Auto-generated method stub
		return homeMapper.getPaymentInfoPerDay();
	}

	@Override
	public List<PaymentPerDayVO> getPaymentInfoPerMonth() {
		// TODO Auto-generated method stub
		return homeMapper.getPaymentInfoPerMonth();
	}


	@Override
	public List<PaymentPerDayVO> getSalesHitTopList() {
		// TODO Auto-generated method stub
		return homeMapper.getSalesHitTopList();
	}

}

