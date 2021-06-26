package com.spring.contractvb.Services;

import java.math.BigDecimal;
import java.util.List;

import com.spring.contractvb.DataResponse.CustomerAPI;
import com.spring.contractvb.DataResponse.CustomerSiteAPI;
import com.spring.contractvb.Entity.CustomerSite_EO;
import com.spring.contractvb.Entity.Customer_EO;
import com.spring.contractvb.Repository.CustomerSite_RP;
import com.spring.contractvb.Repository.Customer_RP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
// import org.springframework.data.web.PageableHandlerMethodArgumentResolver;


@Service
public class Customer_SO {

    @Autowired
    private Customer_RP customer_rp;
    
    @Autowired
    private CustomerSite_RP customerSite_rp;


    public ResponseEntity<Object> getall_customer(Pageable pages) {

        Page<Customer_EO> pg=customer_rp.findAll(pages);
        List<Customer_EO> ls=pg.getContent();
        
        CustomerAPI api=new CustomerAPI();

        api.setItems(ls);
        api.setCount(pg.getTotalPages());
        api.setHasMore(pg.hasNext());
        api.setLimit(pg.getSize());
        api.setFirst(pg.isFirst());
        api.setLast(pg.isLast());
        api.setPage(pg.getNumber());
        
        return ResponseEntity.ok(api);
    }

  ****************************************************************************************
  
  
  
  
    public ResponseEntity<Object> getall_customerSite(BigDecimal p_cust_id, BigDecimal p_org_id, Pageable pageable) {
    // public List<CustomerSite_EO> getall_customerSite(BigDecimal p_cust_id, BigDecimal p_org_id) {
        
        Page<CustomerSite_EO> pg=customerSite_rp.getCustomerSite(p_cust_id, p_org_id, pageable);
        // List<CustomerSite_EO> ls=customerSite_rp.getCustomerSite(p_cust_id, p_org_id);
        List<CustomerSite_EO> ls=pg.getContent();
        System.out.println("--<><"+ls.isEmpty());
        System.out.println("--<><"+ls.size());
        CustomerSiteAPI api=new CustomerSiteAPI();

        api.setItems(ls);
        // api.setCount(pg.getTotalPages());
        // api.setHasMore(pg.hasNext());
        // api.setLimit(pg.getSize());
        // api.setFirst(pg.isFirst());
        // api.setLast(pg.isLast());
        // api.setPage(pg.getNumber());
        
        return ResponseEntity.ok(api);          
    
    }







}
