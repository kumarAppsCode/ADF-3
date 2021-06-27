package com.spring.contractvb.Repository;

import java.math.BigDecimal;
// import java.util.List;
import java.util.List;

import com.spring.contractvb.Entity.CustomerSite_EO;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerSite_RP  extends JpaRepository<CustomerSite_EO, BigDecimal>{


    // String customerSiteSQL=
    // " SELECT ORG_ID, CUST_SITE_ID, CUST_ID, SITE_NUMBER,"
    // +" SITE_NAME, ADDRESS1, ADDRESS2, ADDRESS3, ADDRESS4,"
    // +" CITY, POSTAL_CODE, STATE, PROVINCE, COUNTY, COUNTRY"
    // +" FROM xxstg_cust_sites "
    // +" where NVL(CUST_ID, CUST_ID) = NVL(?1,CUST_ID) "
    // +" and NVL(ORG_ID, ORG_ID) = NVL(?2,ORG_ID) "
    // +" and ROWNUM <= 100";


    String customerSiteSQL2=
    " SELECT * from  xxstg_cust_sites  where CUST_ID=?1 and ORG_ID=?2"; 
    String customerSiteSQL3=
    " SELECT * from  xxstg_cust_sites  where CUST_ID=:cusid and ORG_ID=:orgid"; 

    @Query(value=customerSiteSQL3, nativeQuery = true)
    // Page<CustomerSite_EO> getCustomerSite(BigDecimal p_cust_id, BigDecimal p_org_id, Pageable page);

    Page<CustomerSite_EO> getCustomerSite(
                                          @Param("cusid") BigDecimal p_cust_id, 
                                          @Param("orgid") BigDecimal p_org_id,
                                          org.springframework.data.domain.Pageable page);

    // List<CustomerSite_EO> getCustomerSite(@Param("cusid") BigDecimal p_cust_id, 
    //                                       @Param("orgid") BigDecimal p_org_id
    //     // ,org.springframework.data.domain.Pageable page
    //     );



    // String customerSiteSQL=
    // " SELECT ORG_ID, CUST_SITE_ID, CUST_ID, SITE_NUMBER,"
    // +" SITE_NAME, ADDRESS1, ADDRESS2, ADDRESS3, ADDRESS4,"
    // +" CITY, POSTAL_CODE, STATE, PROVINCE, COUNTY, COUNTRY"
    // +" FROM xxstg_cust_sites "
    // +" where NVL(CUST_ID, CUST_ID) IN NVL(:p_customer_id,CUST_ID) "
    // +" and NVL(ORG_ID, ORG_ID) IN NVL(:p_organization_id,ORG_ID) ";
    // // +" ORDER BY ?#{#pageable}";


    // String customerSiteCountSQL="select count(CUST_SITE_ID) "+
    //                              " from xxstg_cust_sites a "+
    //                              " where NVL(a.CUST_ID, a.CUST_ID) :=p_customer_id "+
    //                              " and NVL(a.ORG_ID, a.ORG_ID) :=p_organization_id ";

    // @Query(
    //     nativeQuery = true, 
    //     value =customerSiteSQL
        // ,countQuery = customerSiteCountSQL
        // )
    // Page<CustomerSite_EO> getCustomerSite(
    //                                        @Param("p_customer_id")BigDecimal p_cust_id,
    //                                        @Param("p_organization_id") BigDecimal p_org_id,
    //                                        Pageable pageable
    //                                        );

    // @Query(nativeQuery = true, value =customerSiteSQL)
    // List<CustomerSite_EO>getCustomerSite(
    //                                       @Param("p_customer_id") BigDecimal p_cust_id,
    //                                       @Param("p_organization_id") BigDecimal p_org_id
    //                                        );


    // Page<CustomerSite_EO> findBycustIdAndorgId(BigDecimal p_cust_id, BigDecimal p_org_id, Pageable pageable);


}
