    @RequestMapping(value = "/allLK", method = RequestMethod.GET)
    public ResponseEntity<Object> getallLK(Pageable pages){

        return lookupType_so.getAllLK(pages);
    }
********************************************************************************
	public ResponseEntity<Object> getAllLK(Pageable pages) {
                Page<LookupType_EO> pg=lookupType_ro.findAll(pages);
             List<LookupType_EO>ls=pg.getContent();

                PagenationMeta pgMeta=PagenationMeta.createPagenation(pg);
                
                LookuptypeData lk=new LookuptypeData();
                lk.setLookup_eo(ls);
                lk.setPagenation(pgMeta);

                api.setData(lk);
                api.setStatusCode(HttpStatus.ACCEPTED);
                return ResponseEntity.ok().body(api);
	}
********************************************************************************
PagenationMeta---generic file
LookuptypeData--Data/LookupData
********************************************************************************
public class LookuptypeData {
 
private List<LookupType_EO> lookup_eo;
private PagenationMeta pagenation;
// getter and setter
}
********************************************************************************
