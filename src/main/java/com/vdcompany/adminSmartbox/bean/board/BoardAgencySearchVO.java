package com.vdcompany.adminSmartbox.bean.board;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardAgencySearchVO {

    private int idx;
    private int agc_idx;
    private int store_idx;
    private String company_name;
    private String company_num;
    private String store_name;
    private String store_num;
    private String id;
    private String name;
    private String rate;
    private String mobile;
    private String tel;
    private String email;
    private String memo;
    private int cate;
    private String title;
    private String contents;
    private int status;

    @JsonFormat(pattern = "yyyy-mm-dd HH:mm")
    private Date regdate;

}
