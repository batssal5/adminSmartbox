package com.vdcompany.adminSmartbox.bean.board;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardAgencyVO {

    private int idx;
    private int agc_idx;
    private int store_idx;
    private String id;
    private String name;
    private String company_name;
    private String store_name;
    private int cate;
    private String title;
    private String contents;
    private int status;

    @JsonFormat(pattern = "yyyy-mm-dd HH:mm")
    private Date regdate;

}
