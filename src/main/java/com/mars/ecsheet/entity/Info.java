/**
  * Copyright 2022 json.cn 
  */
package com.mars.ecsheet.entity;
import java.util.Date;

/**
 * Auto-generated: 2022-07-13 16:55:27
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Info {

    private String name;
    private String creator;
    private String lastmodifiedby;
    private Date createdTime;
    private Date modifiedTime;
    private String company;
    private String appversion;
    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setCreator(String creator) {
         this.creator = creator;
     }
     public String getCreator() {
         return creator;
     }

    public void setLastmodifiedby(String lastmodifiedby) {
         this.lastmodifiedby = lastmodifiedby;
     }
     public String getLastmodifiedby() {
         return lastmodifiedby;
     }

    public void setCreatedTime(Date createdTime) {
         this.createdTime = createdTime;
     }
     public Date getCreatedTime() {
         return createdTime;
     }

    public void setModifiedTime(Date modifiedTime) {
         this.modifiedTime = modifiedTime;
     }
     public Date getModifiedTime() {
         return modifiedTime;
     }

    public void setCompany(String company) {
         this.company = company;
     }
     public String getCompany() {
         return company;
     }

    public void setAppversion(String appversion) {
         this.appversion = appversion;
     }
     public String getAppversion() {
         return appversion;
     }

}