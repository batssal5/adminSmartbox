package com.vdcompany.adminSmartbox.mapper;

import com.vdcompany.adminSmartbox.bean.home.PaymentPerDayVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeMapper {


	List<PaymentPerDayVO> getRefundInfoPerDay();		// 일단위 환불 정보 조회
	List<PaymentPerDayVO> getUserQuestionInfoPerDay();	// 일단위 사용자 문의 건수 조회
	List<PaymentPerDayVO> getAgencyQuestionInfoPerDay();// 일단위 관리자 문의 건수 조회
	List<PaymentPerDayVO> getSmartBoxStatusInfo();		// 스마트박스 운용 상태 조회
	List<PaymentPerDayVO> getPaymentInfoPerDay();		// 일단위 결제 상태 조회
	List<PaymentPerDayVO> getPaymentInfoPerMonth();		// 월단위 결제 상태 조회
	List<PaymentPerDayVO> getSalesHitTopList();			// 월단위 결제 상태 조회
	List<PaymentPerDayVO> getSalesHitTopPerBoxList();	// 월단위 박스 매출 TOP 10

}
