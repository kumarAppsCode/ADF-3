Controller
Defatil assing in query param
?sort=id,desc&sort=name


******************************************************************
@GetMapping(value = "/authors")
    private APIResponse getAuthors(@SortDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable){

        APIResponse apiResponse = authorService.getAuthors(pageable);

        return apiResponse;
    }
******************************************************************

Query Param Sort
@GetMapping(value = "/authorsWithNamed")
    private APIResponse getAuthorsWithNamedQuery(Pageable pageable){

        APIResponse apiResponse = authorService.getAuthorsWithNamedQuery(pageable);

        return apiResponse;
    }
