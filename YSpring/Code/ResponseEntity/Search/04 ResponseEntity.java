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
