package com.spring.contractvb.Entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "xxstg_cust_sites")
public class CustomerSite_EO {
   
 @Id
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_hdr_id_seq")
 @SequenceGenerator(name = "contract_hdr_id_seq",sequenceName = "contract_hdr_id_s", allocationSize = 1)
 @Column(name = "cust_site_id")   
 private BigDecimal custSiteId;
 @Column(name = "org_id")
 private BigDecimal orgId;
 @Column(name = "cust_id")
 private BigDecimal custId;
 @Column(name = "site_number")
 private String siteNumber;
 @Column(name = "siteName")
 private String siteName;
 @Column(name = "address1")
 private String address1;
 @Column(name = "address2")
 private String  address2;
 @Column(name = "address3")
 private String  address3;
 @Column(name = "address4")
 private String  address4;
 @Column(name = "city")
 private String  city;
 @Column(name = "postal_code")
 private String  postal_code;
 @Column(name = "state")
 private String  state;
 @Column(name = "province")
 private String  province;
 @Column(name = "county")
 private String county;
 @Column(name = "country")
 private String country;
}
