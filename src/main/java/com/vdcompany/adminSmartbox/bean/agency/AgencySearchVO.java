package com.vdcompany.adminSmartbox.bean.agency;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgencySearchVO {		

	private int idx;
	private String agency_idx;
	private String agency_name;
	private String agency_num;
	private String store_idx;
	private String store_name;
	private String store_num;
	private String contract_idx;
	private String pg1;
	private String pg2;
	private String vd1;
	private String vd2;
	private String reg1;
	private String reg2;

}
