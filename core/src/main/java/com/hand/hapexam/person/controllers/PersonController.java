package com.hand.hapexam.person.controllers;

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
import javax.servlet.http.HttpServletRequest;
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
    }