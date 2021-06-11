package com.vdcompany.adminSmartbox.service;

import com.vdcompany.adminSmartbox.bean.home.PaymentPerDayVO;

import java.util.List;

public interface HomeService {

	List<PaymentPerDayVO> getPaymentInfoPerDay();		// 일단위 1주일 매출
	List<PaymentPerDayVO> getPaymentInfoPerMonth();		// 월 단위 매출 (최근6개월)
	List<PaymentPerDayVO> getSalesHitTopList();			// 지난 달 판매 순위 top 10
	
}
