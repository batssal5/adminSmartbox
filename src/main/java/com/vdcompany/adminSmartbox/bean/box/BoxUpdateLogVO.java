package com.vdcompany.adminSmartbox.bean.box;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoxUpdateLogVO {		// 본사

	private String box_idx;
	private String agc_idx;
	private String store_idx;
	
	private String agc_mem_idx;
	private String agc_mem_name;
	
	private String store_name;
	
	private Date regdate = new Date();
}
