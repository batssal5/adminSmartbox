package com.vdcompany.adminSmartbox.bean.agency;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgencyStoreListVO {	//지점

	private List<AgencyStoreVO> list;
}


