package com.contract.module.contractmodule.Entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "XXSM_CONTRACT_HEADER_V")
public class SearchContractRO_EO {
    
@Id
@Column(name = "CONTRACT_ID")    
public BigDecimal contractId;
@Column(name = "CONTRACT_NUMBER")    
public String contractNumber;
@Column(name = "CONTRACT_NAME")
public String contractName;
@Column(name = "CONTRACT_DATE")
@JsonFormat(pattern="dd-MM-YYYY")
public Date contractDate;
@Column(name = "CONTRACT_START_DATE")
@JsonFormat(pattern="dd-MM-YYYY")
public Date contractStartDate;
@JsonFormat(pattern="dd-MM-YYYY")
@Column(name = "CONTRACT_END_DATE")
public Date contractEndDate;
@Column(name = "CONTRACT_AMOUNT")
public BigDecimal contractAmount;
@Column(name = "ORG_ID")
public BigDecimal orgId;
@Column(name = "CUST_ID")
public BigDecimal custId;
@Column(name = "CUST_SITE_ID")
public BigDecimal custSiteId;
@Column(name = "CUST_CONTACT_ID")
public BigDecimal custContactId;
@Column(name = "DESCRIPTION")
public String description;
@Column(name = "ACTIVE_YN")
public String activeYN;
@Column(name = "CREATED_BY")
public String createdBy;
@Column(name = "CREATION_DATE")
@JsonFormat(pattern="dd-MM-YYYY")
public Date createdDate;
@Column(name = "LAST_UPDATED_BY")
public String lastUpdateBy;
@Column(name = "LAST_UPDATE_DATE")
@JsonFormat(pattern="dd-MM-YYYY")
public Date lastupdateDate;
@Column(name = "ORG_NAME")
public String orgName;
@Column(name = "CUSTOMER_NUMBER")
public String customerNumber;
@Column(name = "CUSTOMER_NAME")
public String customerName;
@Column(name = "SITE_NUMBER")
public String siteNumber;
@Column(name = "ADDRESS1")
public String address1;
@Column(name = "ADDRESS2")
public String address2;
@Column(name = "ADDRESS3")
public String address3;
@Column(name = "ADDRESS4")
public String address4;
@Column(name = "CITY")
public String city;
@Column(name = "CONTACT_NAME")
public String contactName;
@Column(name = "MOBILE_NUMBER")
public String mobileNumber;
@Column(name = "PHONE_NUMBER")
public String phoneNumber;
@Column(name = "EMAIL_ID")
public String emailId;
}
