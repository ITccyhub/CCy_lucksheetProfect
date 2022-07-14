
/** 
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.mars.ecsheet.controller;


import cn.hutool.json.JSONUtil;
import com.google.gson.Gson;
import com.mars.ecsheet.common.AjaxResult;
import com.mars.ecsheet.entity.JsonRootBean;
import com.mars.ecsheet.entity.WorkBookEntity;
import com.mars.ecsheet.entity.WorkSheetEntity;
import com.mars.ecsheet.repository.WorkBookRepository;
import com.mars.ecsheet.repository.WorkSheetRepository;
import com.mars.ecsheet.utils.SheetUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
* @desc: Luckysheet-online-teamwork-edit-demo
* @name: ImportExcelController.java
* @author: tompai
* @email：liinux@qq.com
* @createTime: 2021年5月22日 下午4:34:04
* @history:
* @version: v1.0
*/
@Controller
public class ImportExcelController {

    @Autowired
    private WorkBookRepository workBookRepository;

    @Autowired
    private WorkSheetRepository workSheetRepository;

    // 接受前端传来的exceldata",存到数据库中 并返回dataid



    @ResponseBody
    @PostMapping("/excel/importFile")
    public AjaxResult importExcelFile(@RequestParam(value = "exceldata") String exceldata, HttpServletRequest request,
                                      HttpServletResponse response) throws IOException {
        // 去除luckysheet中 &#xA的换行
//实例化一个Gson对象
        Gson gson = new Gson();

//            JSONObject jsonObj = JSONObject.fromObject(exceldata);


            
//转为相应的实体对象

        JsonRootBean jsonRootBean = gson.fromJson(exceldata, JsonRootBean.class);
           //字符串去除 .xlsx


          // 将json数据转为jsonArray


        //转换为json格式
        WorkBookEntity wb = new WorkBookEntity();
        wb.setName(jsonRootBean.getInfo().getName().replace(".xlsx", ""));
        wb.setOption(SheetUtil.getDefautOption(jsonRootBean));
        WorkBookEntity saveWb = workBookRepository.save(wb);
        //生成sheet数据
        jsonRootBean.getSheets().forEach(sheet -> {
            WorkSheetEntity ws = new WorkSheetEntity();
            ws.setWbId(saveWb.getId());
            cn.hutool.json.JSONObject jsonObject = JSONUtil.parseObj(sheet);
            ws.setData(jsonObject);
            ws.setDeleteStatus(0);
            workSheetRepository.save(ws);
        });
        return new AjaxResult(200, "success", saveWb.getId().toString());



    }
//    @PostMapping("/excel/importFile")
//    public JSONObject importExcelFile(@RequestParam(value = "exceldata") String exceldata) {
//                Gson gson = new Gson();
//        JSONObject jsonObj = JSONObject.fromObject(exceldata);
////转为相应的实体对象
//
//        JsonRootBean jsonRootBean = gson.fromJson(jsonObj.toString(), JsonRootBean.class);
//           //字符串去除 .xlsx
//
//
//          // 将json数据转为jsonArray
//
//
//        //转换为json格式
//        WorkBookEntity wb = new WorkBookEntity();
//        wb.setName(jsonRootBean.getInfo().getName().replace(".xlsx", ""));
//        wb.setOption(SheetUtil.getDefautOption(jsonRootBean));
//        WorkBookEntity saveWb = workBookRepository.save(wb);
//        //生成sheet数据
//        jsonRootBean.getSheets().forEach(sheet -> {
//            WorkSheetEntity ws = new WorkSheetEntity();
//            ws.setWbId(saveWb.getId());
//            cn.hutool.json.JSONObject jsonObject = JSONUtil.parseObj(sheet);
//            ws.setData(jsonObject);
//            ws.setDeleteStatus(0);
//            workSheetRepository.save(ws);
//        });
//
//        //写一个json字符串，返回给前端
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("id", saveWb.getId());
//
//        return jsonObject;
//
//
//
//
//
//    }


    @GetMapping("/import")
    public String importExcel() {
        return "import";
    }


}
