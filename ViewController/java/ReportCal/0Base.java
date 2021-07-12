    public void customerMasterDownload(ActionEvent actionEvent) {
        String url = null;
        String customerName = "0";
        String path = null;
        String customerId = "0";
//        String l_propertyId="59";
        ViewObject funVo = ADFUtils.getApplicationModuleForDataControl("PrismReport_AMDataControl").findViewObject("Functions_VO");
        ViewCriteria vc = funVo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        vcRow.setAttribute("FuncShortCode", "CUST_M");
        vc.addRow(vcRow);
        funVo.applyViewCriteria(vc);
        funVo.executeQuery();
        if (funVo.first() != null) {
            Row r = funVo.first();
            path = r.getAttribute("PagePath") == null ? "" : r.getAttribute("PagePath").toString();
        }
        funVo.applyViewCriteria(null);
        
        if (customerLov.getValue() != null) {
            customerName = customerLov.getValue().toString();
            customerId = getCustomerId(customerName);
        }
        System.err.println("cust ==>"+customerLov.getValue());
        
        
        ViewObject proVO=ADFUtils.findIterator("PropertyMasterRO1Iterator").getViewObject();
        
        String l_propertyId=proVO.getCurrentRow().getAttribute("Id")==null?"59":proVO.getCurrentRow().getAttribute("Id").toString();
         System.err.println("l_propertyId=>"+l_propertyId);
        
//        if(propertyId.getValue()!=null){
//            l_propertyId=propertyId.getValue().toString();    
//        }
//        System.err.println("pro id==>"+propertyId.getValue());
       
        System.err.println(path+"-----"+customerName);
        url = path + "?P_CUST=" + customerId+"&P_PRO_ID=" + l_propertyId;
        System.err.println("URL--> "+url);
        
        FacesContext fctx = FacesContext.getCurrentInstance();
        String taskflowURL = url;
        ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
        StringBuilder script = new StringBuilder();
        script.append("window.open(\"" + taskflowURL + "\");");
        erks.addScript(fctx, script.toString());
    }
