package com.hand.hapexam.person.controllers;

<<<<<<< HEAD
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
=======
>>>>>>> 99a32cf3dbe2862262b795f13c8c21c22660794c
import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import com.hand.hapexam.person.dto.Person;
import com.hand.hapexam.person.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
<<<<<<< HEAD
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
=======
import javax.servlet.http.HttpServletRequest;
>>>>>>> 99a32cf3dbe2862262b795f13c8c21c22660794c
import java.util.List;

    @Controller
    public class PersonController extends BaseController{

    @Autowired
    private IPersonService service;


    @RequestMapping(value = "/person/query")
    @ResponseBody
    public ResponseData query(Person dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
        @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.select(requestContext,dto,page,pageSize));
    }

    @RequestMapping(value = "/person/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody List<Person> dto){
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "/person/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<Person> dto){
        service.batchDelete(dto);
        return new ResponseData();
    }
<<<<<<< HEAD

        @RequestMapping(value = "/person/excel")
        public void Excel(HttpServletResponse response, HttpServletRequest request){

             String fileName = request.getParameter("fileName");
             System.out.println(fileName);
            //得到表格中所有的数据
            JSONArray jarray = new JSONArray();
            List<Person> listExcel=service.getAllByExcel(fileName);
            JSONObject obj = null;
            for (Person list : listExcel) {
                obj = new JSONObject();
                obj.put("name",list.getName());
                obj.put("telephone",list.getTelephone());
                obj.put("email",list.getEmail());
                obj.put("address",list.getAddress());
                obj.put("gender",list.getGender());
                jarray.add(obj);
            }
            try {
                PrintWriter pw = response.getWriter();
                pw.print(jarray);
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
=======
>>>>>>> 99a32cf3dbe2862262b795f13c8c21c22660794c
    }