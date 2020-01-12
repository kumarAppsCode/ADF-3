    public void newQryOperationListener(QueryOperationEvent queryOperationEvent) {
        invokeMethodExpression("#{bindings.cancellationROVOCriteriaQuery.processQueryOperation}", Object.class,
                               QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation()
                               .name()
                               .toUpperCase()
                               .equals("RESET")) {
            ADFUtils.findOperation("doQueryReset").execute();
            AdfFacesContext.getCurrentInstance().addPartialTarget(resultTable);
            AdfFacesContext.getCurrentInstance().addPartialTarget(searchQry);
        }
    }
	
	    public void doQueryReset(){
        ViewCriteria vc = getcancellation_ROVO1().getViewCriteria("SearchMilestones_ROVOCriteria");
        getcancellation_ROVO1().removeViewCriteria("cancellation_ROVOCriteria");
        getcancellation_ROVO1().executeEmptyRowSet();
        getcancellation_ROVO1().applyViewCriteria(vc);
    }
	
	    public void resetQry() { 
        ViewObject vo = ADFUtils.getApplicationModuleForDataControl("NewMoveAppModuleDataControl").findViewObject("cancellation_ROVO1"); 
        ViewCriteria vc = vo.getViewCriteriaManager().getViewCriteria("cancellation_ROVOCriteria"); 
        vo.setNamedWhereClauseParam("p_orgName", "0");
        vo.applyViewCriteria(vc);
        vo.executeQuery();
    }
