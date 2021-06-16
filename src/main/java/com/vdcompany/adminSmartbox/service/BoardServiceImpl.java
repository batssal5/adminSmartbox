package com.vdcompany.adminSmartbox.service;

import com.vdcompany.adminSmartbox.bean.board.BoardAgencySearchVO;
import com.vdcompany.adminSmartbox.bean.board.BoardAgencyVO;
import com.vdcompany.adminSmartbox.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;

    @Override
    public List<BoardAgencyVO> getBoardAgency(){
        return boardMapper.getBoardAgency();
    }

    @Override
    public List<BoardAgencyVO> getBoardAgencyList(int agc_idx) {
        return boardMapper.getBoardAgencyList(agc_idx);
    }

    @Override
    public List<BoardAgencyVO> getBoardAgencySearchList(BoardAgencySearchVO search) {
        return boardMapper.getBoardAgencySearchList(search);
    }
}
