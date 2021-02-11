package com.module.admin_module.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "xxfnd_functions", schema = "XXPM_TEST")

public class Function_EO {
     
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "function_id_seq")
    @SequenceGenerator(name = "function_id_seq",sequenceName = "XXFND_FUNC_ID_S", allocationSize = 1)
    @Column(name = "FUNC_ID")
    public Integer funcid;
    
    
    @Column(name = "FUNC_NAME")
    public String  funcname;
    @Column(name = "FUNC_SHORT_CODE")
    public String  funcshortcode;
    @Column(name = "AUTO_NUMBER_YN")
    public String  autonumberyn;
    @Column(name = "PREFIX")
    public String  prefix;
    @Column(name = "NEXT_NUMBER")
    public Integer nextnumber;
    @Column(name = "PAGE_PATH")
    public String  pagepath;
    @Column(name = "ACTIVE_YN")
    public String  activeyn;
    @Column(name = "INACTIVE_ON")
    public Date    inactiveon;
    @Column(name = "ATTRIBUTE_CATEGORY")
    public String  attributecategory;
    @Column(name = "ATTRIBUTE1")
    public String  attribute1;
    @Column(name = "ATTRIBUTE2")
    public String  attribute2;
    @Column(name = "ATTRIBUTE3")
    public String  attribute3;
    @Column(name = "ATTRIBUTE4")
    public String  attribute4;
    @Column(name = "ATTRIBUTE5")
    public String  attribute5;
    @Column(name = "ATTRIBUTE6")
    public String  attribute6;
    @Column(name = "ATTRIBUTE7")
    public String  attribute7;
    @Column(name = "ATTRIBUTE8")
    public String  attribute8;
    @Column(name = "ATTRIBUTE9")
    public String  attribute9;
    @Column(name = "ATTRIBUTE10")
    public String  attribute10;
    @Column(name = "CREATED_BY")
    public String  createdby;
    @Column(name = "CREATION_DATE")
    public Date    creationdate;
    @Column(name = "LAST_UPDATED_BY")
    public String  lastupdatedby;
    @Column(name = "LAST_UPDATE_DATE")
    public Date    lastupdatedate;
    @Column(name = "LAST_UPDATE_LOGIN")
    public String  lastupdatelogin;
    @Column(name = "FUNC_TYPE")
    public String  functype;



    public Function_EO() {
    }

-------- Getter/Setter
-------- Construtor

    

}
