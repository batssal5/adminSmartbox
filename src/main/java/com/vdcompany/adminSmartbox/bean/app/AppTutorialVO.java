package com.vdcompany.adminSmartbox.bean.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppTutorialVO {

    private List<Map<String,String>> listMap;

    private String os;
    private String app;
    private String sort;
    private String src;

}
