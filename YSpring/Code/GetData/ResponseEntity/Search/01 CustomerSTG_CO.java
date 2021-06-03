package com.contract.module.contractmodule.Controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.contract.module.contractmodule.Services.CustomerSTG_SO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;


@RestController
@RequestMapping(value = "module/")
@Api(
    tags = {"Customer Details"}, 
    description = "Customer Details based services for Contract Module", 
    value = "Customer Info", 
    produces = "application/json"
    )
public class CustomerSTG_CO {
    
    @Autowired
    private CustomerSTG_SO customerSTG_so;


    @RequestMapping(value = "/customer" ,method = RequestMethod.GET)
    public List<Map<String, Object>> getall_customer(){ 
        List<Map<String, Object>> result=customerSTG_so.getall_customer();
        return result;
    }


    @RequestMapping(value = "/customer/site" ,method = RequestMethod.GET)
    public List<Map<String, Object>> getall_customerSite(
        @RequestParam (value = "p_cust_id", required = false) BigDecimal p_cust_id,
        @RequestParam (value = "p_org_id", required = false) BigDecimal p_org_id
    ){ 
        List<Map<String, Object>> result=customerSTG_so.getall_customerSite(p_cust_id, p_org_id);
        return result;
    }

    @RequestMapping(value = "/customer/contact" ,method = RequestMethod.GET)
    public List<Map<String, Object>> getall_customerContatct(
        @RequestParam (value = "p_cust_id", required = false) BigDecimal p_cust_id,
        @RequestParam (value = "p_cust_site_id", required = false) BigDecimal p_cust_site_id
    ){ 
        List<Map<String, Object>> result=customerSTG_so.getall_customerContact(p_cust_id, p_cust_site_id);
        return result;
    }



}
