package com.vdcompany.adminSmartbox.bean.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardAgencyListVO {

    private List<BoardAgencyVO> list;

}
