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
	private String company_num;
	private String company_type = "0";
	
	private String commission_vd;
	private String commission_pg;

	private String rep_nm;
	private String rep_tel;
	private String rep_email;
	private String rep_mobile;
	
	private String zipcode;
	private String address;
	private String addr_detail;

	private Date regdate = new Date();
	private Date moddate = new Date();

	private int contract;	

	private String description;		// 메모?

	
	

}
