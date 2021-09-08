package com.contract.module.contractmodule.Entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "XXSM_CONTRACT_HEADER")
// @JsonInclude(JsonInclude.Include.NON_NULL)
public class Contract_EO {

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_hdr_id_seq")
@SequenceGenerator(name = "contract_hdr_id_seq",sequenceName = "contract_hdr_id_s", allocationSize = 1)
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
public Date  contractStartDate;
@Column(name = "CONTRACT_END_DATE")
@JsonFormat(pattern="dd-MM-YYYY")
public Date  contractEndDate;
@Column(name = "CONTRACT_AMOUNT")
public BigDecimal contractAmount;
@Column(name = "ORG_ID")
public BigDecimal orgId;
@Column(name = "CUST_SITE_ID")
public BigDecimal  custSiteId;
@Column(name = "CUST_ID")
public BigDecimal custId;
@Column(name = "CUST_CONTACT_ID")
public BigDecimal  custContactId;
@Column(name = "DESCRIPTION")
public String description;
@Column(name = "ACTIVE_YN")
public String  activeYn;
@Column(name = "CREATED_BY")
public String  createdBy;
@Column(name = "CREATION_DATE")
@JsonFormat(pattern="dd-MM-YYYY")
public Date createdDate;
@Column(name = "LAST_UPDATED_BY")
public String lastUpdateBy;
@Column(name = "LAST_UPDATE_DATE")
@JsonFormat(pattern="dd-MM-YYYY")
public Date lastUpdateDate;
@Column(name = "LAST_UPDATE_LOGIN")
public String lastUpdateLogin;

      
}
