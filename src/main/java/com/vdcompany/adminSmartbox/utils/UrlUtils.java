package com.vdcompany.adminSmartbox.utils;
  
public class UrlUtils {

        public String UnicodeToString(String values) {
            String str = values.split(" ")[0];
            str = str.replace("\\","");
            String[] arr = str.split("u");
            String text = "";
            for(int i = 1; i < arr.length; i++){
                int hexVal = Integer.parseInt(arr[i], 16);
                text += (char)hexVal;
            }
            return text;
        }
}