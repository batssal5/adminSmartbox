package com.vdcompany.adminSmartbox.bean.home;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentPerDayVO {
	private String daytime;
	private String customer_cnt;
	private String amount_per_day;
	private String amount_per_day_form;
	private String amount_per_month;
	private String amount_per_month_form;
	private String amount_per_customer;
	private String amount_per_customer_form;
	private int sales_cnt;
	private String goods_name;
	private String alias;
	private int count;
	private int online;
	private int offline;
}
