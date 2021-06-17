package com.vdcompany.adminSmartbox.bean.policy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyVO {
    private List<Map<String,String>> listMap;

    private int app_type;
    private String cate;
    private String a_context;
    private String c_context;

}
