package com.services.mail.Services;

import java.util.Map;

import com.services.mail.PackageCalling.PackageCalUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MailServiceSO {


    @Autowired
    private PackageCalUtils packageCalUtils;

    public ResponseEntity<Object>  bookingProcess(Map<String, Object> content) {

        String P_FUNC_ID=(String) content.get("p_fun_id");
        String P_REF_ID=(String) content.get("p_ref_id");
        String P_LEVEL_NO=(String) content.get("p_level_no");
        String P_TABLE_NAME = (String) content.get("p_table");
        String P_STATUS_COLUMN = (String) content.get("p_status_column");
        String P_PK_COLUMN = (String) content.get("p_pk_column");
        String P_AMOUNT = (String) content.get("p_amount");
        String P_ATTRIBUTE1 = content.get("p_attribute1")==null ? null :(String) content.get("p_attribute1");
        String P_ATTRIBUTE2 = content.get("p_attribute2")==null ? null :(String) content.get("p_attribute2");
        String P_ATTRIBUTE3 = content.get("p_attribute3")==null ? null :(String) content.get("p_attribute3");
        String P_ATTRIBUTE4 = content.get("p_attribute4")==null ? null :(String) content.get("p_attribute4");
        String P_ATTRIBUTE5 = content.get("p_attribute5")==null ? null :(String) content.get("p_attribute5");

        System.out.println("P_FUNC_ID=>"+P_FUNC_ID);
        System.out.println("P_REF_ID=>"+P_REF_ID);
        System.out.println("P_LEVEL_NO=>"+P_LEVEL_NO);
        System.out.println("P_TABLE_NAME=>"+P_TABLE_NAME);
        System.out.println("P_STATUS_COLUMN=>"+P_STATUS_COLUMN);
        System.out.println("P_PK_COLUMN=>"+P_PK_COLUMN);
        System.out.println("P_AMOUNT=>"+P_AMOUNT);
        System.out.println("P_ATTRIBUTE1=>"+P_ATTRIBUTE1);
        System.out.println("P_ATTRIBUTE2=>"+P_ATTRIBUTE2);
        System.out.println("P_ATTRIBUTE3=>"+P_ATTRIBUTE3);
        System.out.println("P_ATTRIBUTE4=>"+P_ATTRIBUTE4);
        System.out.println("P_ATTRIBUTE5=>"+P_ATTRIBUTE5);

        //  PackageCalUtils pcu=new PackageCalUtils();
        
         Map<String, Object> a= packageCalUtils.submitPackage(P_FUNC_ID, P_REF_ID, P_LEVEL_NO, P_TABLE_NAME, 
                           P_STATUS_COLUMN, P_PK_COLUMN, P_AMOUNT, 
                           P_ATTRIBUTE1, P_ATTRIBUTE2, P_ATTRIBUTE3, 
                           P_ATTRIBUTE4, P_ATTRIBUTE5);
        System.out.println("a=>"+a);                         
        return ResponseEntity.ok("ok");
        

    }



    
}
