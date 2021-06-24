package com.vdcompany.adminSmartbox.bean.goods;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsVO  {		// 본사

	private int idx = -1;
	private int agency_idx = -1;
	private int skuid = -1;
	private int box_idx = -1;
	private int goods_idx = -1;
	private String company_nm = "";
	private String goods_name = "";
	private String goods_code = "";
	private String barcode = "";
	private int brand = -1;
	private String brand_name;
	
	private String image;
	private MultipartFile imgFile;
	private int weight = -1;
	private int status = -1;
	private int used = -1;

	private int price = -1;
	private int box_price = -1;
	private int box_used = -1;
	private int agc_price = -1;
	private int agc_used = -1;
	private int agc_sto_idx = -1;
	private String sto_name = "";
	private String box_name = "";
	private int sto_price = -1;
	private int sto_used = -1;
	private int goods_price = -1;
	private int goods_used = -1;

	private Date regdate = null;
	private String regdate1;
	private String regdate2;
	
	private Date moddate = null;

	private String description;
	private String groupby;

	
	

}
