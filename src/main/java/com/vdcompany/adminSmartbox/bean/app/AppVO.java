package com.vdcompany.adminSmartbox.bean.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppVO {

    private List<Map<String, String>> listMap;

    //version
    private String c_version;
    private String c_version_pre;
    private String a_version;
    private String a_version_pre;

    //tutorial
    private String os;
    private String app;
    private String sort;
    private String src;

    //policy
    private int app_type;
    private String cate;
    private String a_context;
    private String c_context;

    //auth
    private String c_auth_conn;
    private String c_auth_purchase;
    private String c_auto_logout_min;
    private String a_auth_inventory;
    private String a_auto_logout_min;

    //refund
    private int idx;
    private String refund_key;
    private String refund_value;

    //payment
    private int card_type;
    private int using_type;
    private int pay_value;

}
