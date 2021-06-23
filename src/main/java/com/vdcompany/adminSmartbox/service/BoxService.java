package com.vdcompany.adminSmartbox.service;

import java.util.List;
import java.util.Map;

import com.vdcompany.adminSmartbox.bean.box.BoxVO;
import com.vdcompany.adminSmartbox.bean.box.InventoryVO;
import com.vdcompany.adminSmartbox.bean.web.paging.PagingVO;

public interface BoxService {
	List<BoxVO> getBoxList(PagingVO pagingVO);
	int putBox(BoxVO boxVO);
	int postBox(Map<String, Object> map);
	int deleteBox(Map<String, Object> map);

	List<InventoryVO> getInventoryInfo(PagingVO pagingVO);
	List<InventoryVO> getInventoryDetailInfo(PagingVO pagingVO);
}
