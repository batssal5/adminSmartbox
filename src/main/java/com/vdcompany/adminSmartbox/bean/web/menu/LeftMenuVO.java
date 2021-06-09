package com.vdcompany.adminSmartbox.bean.web.menu;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeftMenuVO {

	private String menu_name;
	private String menu_icon;
	private String link_url;
	List<LeftMenuSubVO> leftMenuSub = null;

}
