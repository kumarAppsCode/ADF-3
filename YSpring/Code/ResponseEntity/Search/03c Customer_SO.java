package com.spring.contractvb.Services;

import java.math.BigDecimal;
import java.util.List;

import com.spring.contractvb.DataResponse.CustomerAPI;
import com.spring.contractvb.DataResponse.CustomerSiteAPI;
import com.spring.contractvb.Entity.*;
import com.spring.contractvb.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


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


    public ResponseEntity<Object> getall_customerSite1(BigDecimal p_cust_id, BigDecimal p_org_id
    ,Pageable page
    ) {
        Page<CustomerSite_EO> pg=customerSite_rp.getCustomerSite(p_cust_id, p_org_id,page);
        List<CustomerSite_EO> ls=pg.getContent();
        CustomerSiteAPI api=new CustomerSiteAPI();
        api.setItems(ls);
        api.setCount(pg.getTotalPages());
        api.setHasMore(pg.hasNext());
        api.setLimit(pg.getSize());
        api.setFirst(pg.isFirst());
        api.setLast(pg.isLast());
        api.setPage(pg.getNumber());
        return ResponseEntity.ok(api);
    }


 








}
