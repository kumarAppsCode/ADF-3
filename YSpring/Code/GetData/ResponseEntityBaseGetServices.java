    @RequestMapping("/lk")
    public ResponseEntity<Object> findByLookupTypeids(
                                        @RequestParam(name = "ids", required = false)Integer ids){
        return lookupType_so.findLookupIDS(ids);
    }
=============================================================================================================
          APIResponse api=new APIResponse();
	public ResponseEntity<Object> findLookupIDS(Integer ids) {
                if(ids==null){
                        List<LookupType_EO> ls = lookupType_ro.findAll();
                        if(ls.isEmpty()){
                                api.setErrorMessage("No Data found"); 
                                api.setStatusCode(HttpStatus.NOT_FOUND);
                             return ResponseEntity.unprocessableEntity().body(api);
                        }else{
                                api.setData(ls);
                                api.setStatusCode(HttpStatus.OK.value());
                             return ResponseEntity.unprocessableEntity().body(api);
                        }
               }else{
                        Optional<LookupType_EO> ls = lookupType_ro.findById(ids);
                        if(ls.isPresent()){
                                api.setData(ls);
                                api.setStatusCode(HttpStatus.ACCEPTED);
                            return ResponseEntity.ok().body(api);            
                        }else{
                               api.setErrorMessage("No Data found"); 
                               api.setStatusCode(HttpStatus.NOT_FOUND);
                            return ResponseEntity.unprocessableEntity().body(api);
                        }             
                }
	}
******************************************************************************************************************************************
Blogs
@GetMapping("/tutorials")
  public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
    try {
      List<Tutorial> tutorials = new ArrayList<Tutorial>();

      if (title == null)
        tutorialRepository.findAll().forEach(tutorials::add);
      else
        tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);

      if (tutorials.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(tutorials, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
**************************************************************************************************
