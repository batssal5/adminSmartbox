package com.vdcompany.adminSmartbox.bean.lookup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LookupVO {

	private int agc_idx;
	private String agency_name;

	private int store_idx;
	private String store_name;

}
