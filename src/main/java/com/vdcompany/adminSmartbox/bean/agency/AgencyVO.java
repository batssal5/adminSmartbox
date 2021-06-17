package com.vdcompany.adminSmartbox.bean.agency;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgencyVO {		// 본사

	private int idx = 0;
	private String company_name;
	private String company_nm;
	private String company_num;
	private String company_type = "0";
	private String rep_nm;
	private String rep_tel;
	private String rep_email;
	private String rep_mobile;
	private String zipcode;
	private String address;
	private String addr_detail;
	private Date regdate = new Date();
	private Date moddate = new Date();
	private String description;		// 메모?

	private int store_idx;
	private int agc_idx;
	private String store_name;
	private String store_company_num;
	private String store_zipcode;
	private String store_address;
	private String store_addr_detail;
	private int cate;
	private String cate_name;
	private int contract;
	private int used;
	private String vd_comm;
	private String pg_comm;


}
