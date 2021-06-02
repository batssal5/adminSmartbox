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

	private int idx = 0;
	private String skuid;
	private String name;
	private String gcode;
	private String barcode;
	private String brand;
	private String brand_name;
	
	private String image;
	private MultipartFile imgFile;
	private String weight;
	private String status;
	private String used;

	private String price;
	private String price1;
	private String price2;

	private Date regdate = new Date();
	private String regdate1;
	private String regdate2;
	
	private Date moddate = new Date();

	private String description;		// 메모?

	
	

}
