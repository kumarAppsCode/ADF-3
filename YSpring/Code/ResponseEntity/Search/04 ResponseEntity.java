    @RequestMapping(value = "/getServices" ,method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<Service_EO>>> getServices(){
        return service_so.getServices();
    }

    public ResponseEntity<Map<String, List<Service_EO>>> getServices() {
        Map<String, List<Service_EO>> response = new HashMap<String, List<Service_EO>>();
        List<Service_EO> ls=service_ro.findAll();
        response.put("service", ls);
        return ResponseEntity.ok().body(response);
    }
******************************************************************************************************************************************
    @RequestMapping(value = "/getScheduleNotes" ,method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getScheduleNotes(
        @RequestParam(name = "scheduleId", required = false)String scheduleId
    ){
        return scheduleNote_so.getScheduleNotes(scheduleId);
    }
    
    public ResponseEntity<Map<String, Object>> getScheduleNotes(String scheduleId) {
        Map<String, Object> response = new HashMap<String, Object>();
        if(scheduleId==null){
            List<ScheduleNote_EO> ls = scheduleNote_ro.findAll();
            response.put("schedulenote", ls);

            return ResponseEntity.ok().body(response);            
        }else{
            Optional<ScheduleNote_EO> ls = scheduleNote_ro.findById(new BigDecimal(scheduleId));
            response.put("schedulenote", ls);
            return ResponseEntity.ok().body(response);            

        }
        
    }
******************************************************************************************************************************************
