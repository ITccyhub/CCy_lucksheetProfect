/**
  * Copyright 2022 json.cn 
  */
package com.mars.ecsheet.entity;
import java.util.List;

/**
 * Auto-generated: 2022-07-13 16:55:27
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class JsonRootBean {

    private Info info;
    private List<Sheets> sheets;
    public void setInfo(Info info) {
         this.info = info;
     }
     public Info getInfo() {
         return info;
     }

    public void setSheets(List<Sheets> sheets) {
         this.sheets = sheets;
     }
     public List<Sheets> getSheets() {
         return sheets;
     }

}