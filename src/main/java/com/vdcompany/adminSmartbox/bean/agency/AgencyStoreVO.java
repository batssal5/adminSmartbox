package com.vdcompany.adminSmartbox.bean.agency;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgencyStoreVO {	//지점

//	private int idx;
//	private int agc_idx;
//	private String company_name;
//	private String company_num;
//	private String store_num;
//	private String store_name;
//	private String zipcode;
//	private String address;
//	private String addr_detail;
//	private int cate;
//	private String cate_name;
//	private int contract;
//	private int used;
//	private String manager;
//	private String tel;
//	private String mobile;
//	private String commission_vd;
//	private String commission_pg;
//
//	private String alias;
//
//	private Date regdate;
//	private Date moddate;
	private String company_name;
	private String company_num;
	private int idx;
	private int agc_idx;
	private String store_name;
	private String store_num;
	private String zipcode;
	private String address;
	private String addr_detail;
	private int cate;
	private String cate_name;
	private int contract;
	private String vd_comm;
	private String pg_comm;
	private int used;
	private String manager;
	private String tel;
	private String mobile;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date regdate;
	private Date moddate;

}


