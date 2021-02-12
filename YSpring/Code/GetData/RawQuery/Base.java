************************************************************************************
@RequestMapping("getraw/")
public List<Function_EO> rawQuery(
                      @RequestParam(value = "ids", required = false) Set<Integer> funID){
      return functionservices.getRawQuery(funID);
}
====================================
	public List<Function_EO> getRawQuery(Set<Integer> funID) {
		return functionrepo.rawQueryFuncId(funID);
	}
==================================
String rawQueryM1="select * from Function_EO where funcid=?1 and funName=?2";

String rawQueryM2="select * from xxfnd_functions where FUNC_ID IN :fun";
@Query(nativeQuery = true, value = rawQueryM2)
List<Function_EO> rawQueryFuncId(@Param("fun") Set<Integer> funID);
************************************************************************************
