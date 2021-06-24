package com.vdcompany.adminSmartbox.bean.web.paging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagingVO {

    private String type;
    private int skip = -1;
    private int take = -1;
    private String requireTotalCount;
    private String totalSummary;
    private String filter;
    private String box_id;
    private String idx;
    private String store_idx;
    private int goods_idx = -1;
    private int agc_idx = -1;
    private int agency_idx = -1;
    private int box_idx = -1;
    private int agc_sto_idx = -1;
    private String groupby;

}