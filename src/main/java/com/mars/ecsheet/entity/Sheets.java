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
public class Sheets {

    private String name;
    private Config config;
    private String index;
    private String status;
    private String order;
    private List luckysheet_select_save;
    private int zoomRatio;
    private String showGridLines;
    private int defaultColWidth;
    private int defaultRowHeight;
    private List<Celldata> celldata;
    private List<CalcChain> calcChain;
    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setConfig(Config config) {
         this.config = config;
     }
     public Config getConfig() {
         return config;
     }

    public void setIndex(String index) {
         this.index = index;
     }
     public String getIndex() {
         return index;
     }

    public void setStatus(String status) {
         this.status = status;
     }
     public String getStatus() {
         return status;
     }

    public void setOrder(String order) {
         this.order = order;
     }
     public String getOrder() {
         return order;
     }

    public void setLuckysheet_select_save(List luckysheet_select_save) {
         this.luckysheet_select_save = luckysheet_select_save;
     }
     public List getLuckysheet_select_save() {
         return luckysheet_select_save;
     }

    public void setZoomRatio(int zoomRatio) {
         this.zoomRatio = zoomRatio;
     }
     public int getZoomRatio() {
         return zoomRatio;
     }

    public void setShowGridLines(String showGridLines) {
         this.showGridLines = showGridLines;
     }
     public String getShowGridLines() {
         return showGridLines;
     }

    public void setDefaultColWidth(int defaultColWidth) {
         this.defaultColWidth = defaultColWidth;
     }
     public int getDefaultColWidth() {
         return defaultColWidth;
     }

    public void setDefaultRowHeight(int defaultRowHeight) {
         this.defaultRowHeight = defaultRowHeight;
     }
     public int getDefaultRowHeight() {
         return defaultRowHeight;
     }

    public void setCelldata(List<Celldata> celldata) {
         this.celldata = celldata;
     }
     public List<Celldata> getCelldata() {
         return celldata;
     }

    public void setCalcChain(List<CalcChain> calcChain) {
         this.calcChain = calcChain;
     }
     public List<CalcChain> getCalcChain() {
         return calcChain;
     }

}