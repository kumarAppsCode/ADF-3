In Child.java
  @Transient
  private String lookupTypeName;
------------------------------------
      public String getLookupTypeName() {
        if(getLookupType().getLookupTypeName().isEmpty()){
            return null;
        }else{
            return getLookupType().getLookupTypeName();
        }
    }

    public void setLookupTypeName(String lookupTypeName) {
        this.lookupTypeName = lookupTypeName;
    }
************************************************************************************
Parent Table
  @OneToOne(targetEntity = xxstg_organizationROVO.class,cascade =CascadeType.MERGE)
    @JoinColumn(name = "ORG_ID")
    // @JsonIgnore
    private xxstg_organizationROVO org;

    @Transient
    private String OrgName;

