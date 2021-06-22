package com.vdcompany.adminSmartbox.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class QueryUtils {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public String whereFilter(List<Object> fList) {
        String WHERE = "";
        boolean fone = false;
        boolean contain_one = false;
        for(int i=0;i<fList.size();i++){
            boolean contain = false;
            logger.info("type:"+fList.get(i).getClass().getTypeName());
            if(fList.get(i).getClass().getTypeName().equals("java.lang.String")){
                if(i==0){
                    fone = true;
                }
                if(fone && i==1 && fList.get(i).toString().trim().contains("contains")){
                    WHERE += "like ";
                    contain_one = true;
                }else {
                    if(i==2){
                        if(contain_one) {
                            WHERE += "'%" + fList.get(i) + "%' ";
                        }else{
                            WHERE += "'" + fList.get(i) + "' ";
                        }
                    }else {
                        WHERE += " " + fList.get(i) + " ";
                    }
                }
            }else if(fList.get(i).getClass().getTypeName().equals("java.lang.Double")){
                WHERE += fList.get(i)+" ";
            }else if(fList.get(i).getClass().getTypeName().equals("java.util.ArrayList")){
                List<Object> listObj = (List<Object>) fList.get(i);
                for(int j=0;j<listObj.size();j++){
                    if(j==0){
                        WHERE += listObj.get(j) + " ";
                    }else if(j==1){
                        if(listObj.get(j).toString().trim().contains("contains")){
                            contain = true;
                            WHERE += "like ";
                        }else {
                            WHERE += listObj.get(j) + " ";
                        }
                    }else if(j==2){
                        if(listObj.get(j).getClass().getTypeName().equals("java.lang.String")) {
                            if(contain){
                                WHERE += "'%" + listObj.get(j) + "%'";
                            }else {
                                WHERE += "'" + listObj.get(j) + "'";
                            }
                        }else{
                            WHERE += listObj.get(j) + " ";
                        }

                    }
                }
            }
        }
        return WHERE;
    }
}