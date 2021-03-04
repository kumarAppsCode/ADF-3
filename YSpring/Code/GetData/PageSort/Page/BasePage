    @RequestMapping(value = "/allLK", method = RequestMethod.GET)
    public ResponseEntity<Object> getallLK(Pageable pages){

        return lookupType_so.getAllLK(pages);
    }
=======================================================================
	public ResponseEntity<Object> getAllLK(Pageable pages) {
		
                Page<LookupType_EO> pg=lookupType_ro.findAll(pages);                
                api.setData(pg);
                api.setStatusCode(HttpStatus.ACCEPTED);
                return ResponseEntity.ok().body(api);
	}
****************************************************************************************************
