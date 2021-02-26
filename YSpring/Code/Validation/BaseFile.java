package com.module.admin_module.Validation;

import java.util.ArrayList;
import java.util.List;

import com.module.admin_module.Entity.LookupType_EO;
import com.module.admin_module.Utils.ErrorHandle;

import org.springframework.stereotype.Component;

@Component
public class LookupTypeVal {

	public List<ErrorHandle> validateSave(LookupType_EO lkentity) {
		
        List<ErrorHandle> ls=new ArrayList<>();

        if(lkentity.getLookupTypeName()==null){
            ErrorHandle err=new ErrorHandle("LookuptypeName","Lookup Name is missing");
            ls.add(err);
        }
        
        if(lkentity.getActiveYn().equals("N")){
            ErrorHandle err=new ErrorHandle("LookupActiveYN","While Save/Update Lookup Active should be Y");
            ls.add(err);
        }
        return ls;
	}
    




}
