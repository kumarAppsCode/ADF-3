package com.spring.contractvb.Controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.spring.contractvb.Entity.CustomerSite_EO;
import com.spring.contractvb.Services.CustomerSTG_SO;
import com.spring.contractvb.Services.Customer_SO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;


@RestController
@RequestMapping(value = "/module")
@Api(
    tags = {"Stagging"}, 
    description = "Customer REST services Application", 
    // value = "HRMS Module", 
    produces = "application/json"
    )
public class CustomerSTG_CO {
    
    @Autowired
    private CustomerSTG_SO customerSTG_so;
    
    @Autowired
    private Customer_SO customer_so;


    @RequestMapping(value = "/customer" ,method = RequestMethod.GET)
    public ResponseEntity<Object> getall_customer(
        @SortDefault(sort = "custName", direction = Direction.DESC) Pageable pageable){ 
        
        return customer_so.getall_customer(pageable);
    }


    @RequestMapping(value = "/customer/site" ,method = RequestMethod.GET)
    public List<Map<String, Object>> getall_customerSite(
        @RequestParam (value = "p_cust_id", required = false) BigDecimal p_cust_id,
        @RequestParam (value = "p_org_id", required = false) BigDecimal p_org_id
        // ,Pageable pageable
    ){ 
  
        List<Map<String, Object>> result=customerSTG_so.getall_customerSite(p_cust_id, p_org_id);

        // return customer_so.getall_customerSite(p_cust_id, p_org_id, pageable);
        
        // List<CustomerSite_EO> ls=customer_so.getall_customerSite(p_cust_id, p_org_id);
        
        // return ResponseEntity.ok(ls);

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
