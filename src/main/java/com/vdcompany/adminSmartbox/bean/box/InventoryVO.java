package com.vdcompany.adminSmartbox.bean.box;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryVO {
	private int idx = -1;
	private int agc_mem_idx = -1;
	private int box_idx = -1;
	private String shp_id = "";
	private String gname = "";
	private int status = -1;
	private Date regdate = new Date();
	private Date moddate = new Date();
	private int box_id = -1;
	private String box_name = "";
	private String company_nm = "";
	private String agc_sto_name = "";
	private String agc_mem_id = "";
	private String agc_mem_name = "";

	private int inv_idx = -1;
	private String goods_name = "";
	private String image = "";
	private int quantity = -1;
	private int price = -1;
	private String price_form = "";


}
