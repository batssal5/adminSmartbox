package com.vdcompany.adminSmartbox.mapper;

import com.vdcompany.adminSmartbox.bean.home.PaymentPerDayVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeMapper {


	List<PaymentPerDayVO> getPaymentInfoPerDay();		// 일단위 결제 상태 조회
	List<PaymentPerDayVO> getPaymentInfoPerMonth();		// 월단위 결제 상태 조회
	List<PaymentPerDayVO> getSalesHitTopList();		// 월단위 결제 상태 조회

}
