package com.vdcompany.adminSmartbox.bean.box;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoxVO {
	private String box_idx;
	private String agc_idx;
	private String store_idx;
	
	private String serial;
	private int box_id;
	private String box_name;
	private String agency_name;
	private String store_name;
	private String store_num;
	private String store_company_num;
	
	private int status = -1;

	private Date regdate = new Date();
	private String regdate_form;
	private String regdate1;
	private String regdate2;

	private Date moddate = new Date();

	private String description;		// 메모?
	private String cate;	
	private String cate_name;	

}
