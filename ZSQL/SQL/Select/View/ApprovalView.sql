create or replace view xxfnd_approval_history_v
as
SELECT
    ah.appr_hist_id as app_his_id,
    ah.func_id as fun_id,
    ah.func_ref_id as ref_id,
    ah.seq_number as seq_number,
    ah.approver_id as approver_id,
    ah.submission_date as submission_date,
    ah.action_date as action_date,
    ah.description as description,
    CASE
        WHEN ah.status = 'A'   THEN
            'Approved'
        WHEN ah.status = 'R'   THEN
            'Rejected'
        WHEN ah.status = 'P'   THEN
            'Pending'
        WHEN ah.status = 'D'   THEN
            'Draft'
    END AS status,
    ah.created_by as created_by,
    ah.creation_date as creation_date,
    ah.last_updated_by as last_updated_by,
    ah.last_update_date as last_update_date,
    ah.user_grp_id as user_grp_id,
    ah.cycle_no as cycle_no,
    ah.cycle_flag as cycle_flag,
    us.user_name as user_name,
    us.user_name_disp as user_name_disp,
    us.user_email_id as user_email_id
FROM
    xxfnd_func_approval_hist   ah,
    xxfnd_user                 us
WHERE
    ah.approver_id = us.user_id;
