package com.vdcompany.adminSmartbox.bean.box;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoxVO {
	private int idx;
	private int box_id;
	private int box_idx;
	private int agc_idx;
	private int store_idx;
	
	private String serial;
	private String box_name;
	private String agency_name;
	private String store_name;
	private int store_num;
	private String store_company_num;
	
	private int status = -1;

	private Date regdate = new Date();
	private String regdate_form;
	private String regdate1;
	private String regdate2;

	private Date moddate = new Date();

	private String description;		// 메모?
	private int cate;
	private String cate_name;	

}
