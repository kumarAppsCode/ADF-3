
CREATE OR REPLACE package XXPM_CANCELLATION_PKG
is

procedure xxpm_update_milestone_status(
    p_primary_id   IN             NUMBER,
    p_func_id      IN             NUMBER,
    p_login_user   IN             VARCHAR2,
    p_out_status   OUT            VARCHAR2
);

end XXPM_CANCELLATION_PKG;
/


CREATE OR REPLACE PACKAGE BODY           XXPM_CANCELLATION_PKG
IS

procedure xxpm_update_milestone_status(
    p_primary_id   IN             NUMBER,
    p_func_id      IN             NUMBER,
    p_login_user   IN             VARCHAR2,
    p_out_status   OUT            VARCHAR2
)
as
begin
null;
   END xxpm_update_milestone_status;
end XXPM_CANCELLATION_PKG;
