package com.vdcompany.adminSmartbox.mapper;

import com.vdcompany.adminSmartbox.bean.board.BoardAgencySearchVO;
import com.vdcompany.adminSmartbox.bean.board.BoardAgencyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardAgencyVO> getBoardAgency();

    List<BoardAgencyVO> getBoardAgencyList(int agc_idx);
    List<BoardAgencyVO> getBoardAgencySearchList(BoardAgencySearchVO search);


}
