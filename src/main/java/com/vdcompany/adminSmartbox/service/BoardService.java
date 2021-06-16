package com.vdcompany.adminSmartbox.service;

import com.vdcompany.adminSmartbox.bean.board.BoardAgencySearchVO;
import com.vdcompany.adminSmartbox.bean.board.BoardAgencyVO;

import java.util.List;

public interface BoardService {

    List<BoardAgencyVO> getBoardAgency();

    List<BoardAgencyVO> getBoardAgencyList(int agc_idx);
    List<BoardAgencyVO> getBoardAgencySearchList(BoardAgencySearchVO search);

}
