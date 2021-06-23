package com.vdcompany.adminSmartbox.bean.agency;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgencyVO {		// 본사

	private int idx = -1;
	private String company_name = "";
	private String company_nm = "";
	private String company_num;
	private String company_type = "0";
	private String rep_nm = "";
	private String rep_tel = "";
	private String rep_email = "";
	private String rep_mobile = "";
	private String zipcode = "";
	private String address = "";
	private String addr_detail = "";
	private Date regdate = null;
	private Date moddate = null;
	private String description = "";

	private int store_idx = -1;
	private int agency_idx = -1;
	private String store_name = "";
	private String store_company_num = "";
	private String store_zipcode = "";
	private String store_address = "";
	private String store_addr_detail = "";
	private int cate = -1;
	private String cate_name = "";
	private int contract = -1;
	private int used = -1;
	private float vd_comm = -1;
	private float pg_comm = -1;
	private Date store_regdate = null;


}
