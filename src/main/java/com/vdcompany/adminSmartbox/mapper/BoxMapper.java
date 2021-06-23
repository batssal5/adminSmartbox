package com.vdcompany.adminSmartbox.mapper;

import java.util.List;
import java.util.Map;

import com.vdcompany.adminSmartbox.bean.web.paging.PagingVO;
import org.apache.ibatis.annotations.Mapper;

import com.vdcompany.adminSmartbox.bean.box.BoxVO;

@Mapper
public interface BoxMapper {
	List<BoxVO> getBoxList(PagingVO pagingVO);		// 박스 리스트
	int postBox(Map<String, Object> map);		// 박스 리스트
	int postBoxInfo(Map<String, Object> map);	// 수정하기
	int deleteBox(Map<String, Object> map);	// 삭제하기
	int deleteBoxInfo(Map<String, Object> map);	// 삭제하기
	int putBox(BoxVO box);		// 박스 리스트
	int putBoxInfo(BoxVO box);		// 박스 리스트
}
