package com.vdcompany.adminSmartbox.service;

import com.vdcompany.adminSmartbox.bean.home.PaymentPerDayVO;

import java.util.List;

public interface HomeService {

	List<PaymentPerDayVO> getRefundInfoPerDay();		// 일단위 환불 카운트
	List<PaymentPerDayVO> getUserQuestionInfoPerDay();	// 일단위 사용자 문의 건수
	List<PaymentPerDayVO> getAgencyQuestionInfoPerDay();// 일단위 관리자 문의 건수
	List<PaymentPerDayVO> getSmartBoxStatusInfo();		// 스마트박스 운용 상태 조회
	List<PaymentPerDayVO> getPaymentInfoPerDay();		// 일단위 1주일 매출
	List<PaymentPerDayVO> getPaymentInfoPerMonth();		// 월 단위 매출 (최근6개월)
	List<PaymentPerDayVO> getSalesHitTopList();			// 지난 달 판매 순위 top 10
	List<PaymentPerDayVO> getSalesHitTopPerBoxList();	// 월단위 박스 매출 TOP 10
	
}
