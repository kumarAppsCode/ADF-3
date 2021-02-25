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
