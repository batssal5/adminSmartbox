package com.vdcompany.adminSmartbox.mapper;

import java.util.List;
import java.util.Map;

import com.vdcompany.adminSmartbox.bean.web.paging.PagingVO;
import org.apache.ibatis.annotations.Mapper;

import com.vdcompany.adminSmartbox.bean.box.BoxVO;

@Mapper
public interface BoxMapper {

	BoxVO getBoxDetail(int idx);

	List<BoxVO> getBoxList(PagingVO pagingVO);		// 박스 리스트
	int postBox(Map<String, Object> map);		// 박스 리스트
	int postBoxInfo(Map<String, Object> map);	// 수정하기
	int deleteBox(Map<String, Object> map);	// 삭제하기
	int deleteBoxInfo(Map<String, Object> map);	// 삭제하기
	int putBox(BoxVO box);		// 박스 리스트
	int putBoxInfo(BoxVO box);		// 박스 리스트
	List<BoxVO> getBoxSearchList(BoxVO search);		// 박스 리스트

	int insertBox(BoxVO box);	// 추가하기
	int insertBoxInfo(BoxVO box);	// 추가하기
	
	int updateBox(BoxVO box);	// 수정하기
	int updateBoxInfo(BoxVO box);	// 수정하기

}
