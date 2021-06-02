package com.vdcompany.adminSmartbox.bean.goods;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDisplayVO  {	

	
	private GoodsVO goods;
	private List<GoodsAgencyVO> agency = new ArrayList<GoodsAgencyVO>();
	
	private String agency_idx;
	private String skuid;

	

}
