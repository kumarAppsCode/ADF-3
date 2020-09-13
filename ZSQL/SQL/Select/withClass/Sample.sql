
  CREATE OR REPLACE FORCE EDITIONABLE VIEW "XXPL_MARCH"."XXPL_OWNER_COMMUNITY_CHARGE_DTL_V" ("OA_CONTRACT_ID", "FUNC_ID", "UNIT_ID", "OA_CONTRACT_INV_ID", "PERIOD_FROM", "PERIOD_TO", "NO_OF_DAYS_LEASED", "NO_OF_DAYS_UNLEASED", "STANDARD_AMT", "STANDARD_TAX", "STANDARD_TOTAL", "SPECIAL_AMT", "SPECIAL_TAX", "SPECIAL_TOTAL", "TOTAL_CHARGE_AMT", "STDCOUNT", "SPECOUNT", "INVOICEAMT", "PREPAYAMT", "OUTSTANDANDAMT", "SOURCES_REF_ID", "SOURCES_FUN_ID", "INV_ID") AS 
  WITH ownerinvdtl AS (
    SELECT
        SUM(NVL(invdtl.amount, 0)) cc_prepay_am,
        invdtl.sources_ref_id,
        invdtl.sources_fun_id,
        invhdr.unit_id,
        invdtl.inv_id
    FROM
        xxpl_owner_invoice_dtl   invdtl,
        xxpl_owner_invoice       invhdr
    WHERE
        invhdr.owner_inv_id = invdtl.owner_inv_id
        AND invdtl.owner_inv_type = 'COMMUNITY_CHARGE'
    GROUP BY
        sources_ref_id,
        sources_fun_id,
        unit_id,
        inv_id
), oainvoice AS (
    SELECT
        oa_contract_id,
        func_id,
        unit_id,
        oa_contract_inv_id,
        period_from,
        period_to,
        no_of_days_leased,
        no_of_days_unleased,
        standard_amt,
        standard_tax,
        standard_total,
        special_amt,
        special_tax,
        special_total,
        total_charge_amt,
        stdcount,
        specount,
        CASE
            WHEN specount = 1   THEN
                special_total
            WHEN stdcount = 0   THEN
                0
            WHEN specount = 2   THEN
                special_total
            ELSE
                special_total
        END AS finalamt
    FROM
        (
            SELECT
                oainv.oa_contract_id,
                oahdr.func_id,
                oahdr.unit_id,
                oainv.oa_contract_inv_id,
                oainv.period_from,
                oainv.period_to,
                oainv.no_of_days_leased,
                oainv.no_of_days_unleased,
                oainv.standard_amt,
                oainv.standard_tax,
                oainv.standard_total,
                oainv.special_amt,
                oainv.special_tax,
                oainv.special_total,
                oainv.total_charge_amt,
                (SELECT NVL(count(*), 0) FROM xxpl_oa_contract_dtl where OA_CHARGE_METHOD in ('OACS') and OA_CONTRACT_ID=oainv.oa_contract_id group by OA_CONTRACT_ID) AS stdcount, 
                (SELECT NVL(count(*), 0) FROM xxpl_oa_contract_dtl where OA_CHARGE_METHOD in ('OACL') and OA_CONTRACT_ID=oainv.oa_contract_id group by OA_CONTRACT_ID) AS specount
--                xxpl_oa_charge_count('OACS', oainv.oa_contract_id) AS stdcount,
--                xxpl_oa_charge_count('OACL', oainv.oa_contract_id) AS specount
            FROM
                xxpl_oa_contract_invoice   oainv,
                xxpl_oa_contract_hdr       oahdr
            WHERE
                oahdr.oa_contract_id = oainv.oa_contract_id
--                AND oahdr.unit_id = 1155
            GROUP BY
                oainv.oa_contract_id,
                oahdr.func_id,
                oahdr.unit_id,
                oainv.oa_contract_inv_id,
                oainv.period_from,
                oainv.period_to,
                oainv.no_of_days_leased,
                oainv.no_of_days_unleased,
                oainv.standard_amt,
                oainv.standard_tax,
                oainv.standard_total,
                oainv.special_amt,
                oainv.special_tax,
                oainv.special_total,
                oainv.total_charge_amt
--                xxpl_oa_charge_count('OACS', oainv.oa_contract_id),
--                xxpl_oa_charge_count('OACL', oainv.oa_contract_id)
        )
)
SELECT
    oadtl.oa_contract_id,
    oadtl.func_id,
    oadtl.unit_id,
    oadtl.oa_contract_inv_id,
    oadtl.period_from,
    oadtl.period_to,
    oadtl.no_of_days_leased,
    oadtl.no_of_days_unleased,
    oadtl.standard_amt,
    oadtl.standard_tax,
    oadtl.standard_total,
    oadtl.special_amt,
    oadtl.special_tax,
    oadtl.special_total,
    oadtl.total_charge_amt,
    oadtl.stdcount,
    oadtl.specount,
    NVL(oadtl.finalamt , 0) as invoiceAmt,
    NVL(owndtl.cc_prepay_am, 0) as prepayAmt,
    NVL(oadtl.finalamt , 0)-NVL(owndtl.cc_prepay_am, 0) as OutStandandAmt,
    owndtl.sources_ref_id,
    owndtl.sources_fun_id,
    owndtl.inv_id
FROM
    oainvoice     oadtl,
    ownerinvdtl   owndtl
WHERE
    owndtl.sources_ref_id (+) = oadtl.oa_contract_id
--    and oadtl.oa_contract_id=oadtl.oa_contract_id+0
--    and owndtl.sources_ref_id=owndtl.sources_ref_id+0
    AND owndtl.sources_fun_id (+) = oadtl.func_id
    AND owndtl.inv_id (+) = oadtl.oa_contract_inv_id
    AND owndtl.unit_id (+) = oadtl.unit_id
--    and NVL(oadtl.finalamt , 0)-NVL(owndtl.cc_prepay_am, 0)<>0
;
