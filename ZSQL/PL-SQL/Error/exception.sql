l_aggrement_exp EXCEPTION; 

begin
SELECT 
agdtl.OA_AGREEMENT_METHOD, agdtl.OA_AGREEMENT_BASED_ON, 
agdtl.OA_AGREEMENT_TYPE, agdtl.RATE, 
agdtl.VAT_CODE, agdtl.VAT_INCLU_EXCLUSIVE 
into 
ll_OA_AGREEMENT_METHOD, ll_OA_AGREEMENT_BASED_ON, 
ll_OA_AGREEMENT_TYPE, ll_RATE, 
ll_VAT_CODE, ll_VAT_INCLU_EXCLUSIVE 
FROM xxpl_oa_contract_dtl condtl, xxpl_oa_agreement_dtl agdtl
where 
agdtl.OA_AGREEMENT_DTL_ID=condtl.OA_AGREEMENT_DTL_ID
and condtl.OA_CHARGE_METHOD='OACL'
and condtl.oa_contract_id=c0.oa_contract_id;
--and condtl.oa_contract_id=287;
exception when others then
raise l_aggrement_exp;
end;

exception
when l_aggrement_exp then
p_msg:='Special OA Contract Details Issue;';
p_msg_code:='E';
when others then 
--raise_application_error(-20001,'An error was encountered - '||SQLCODE||' -ERROR- '||SQLERRM);
p_msg_code:='E';
p_msg :='Error '||SQLERRM;
end;
