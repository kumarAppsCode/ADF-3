define(['ojs/ojpagingdataproviderview','ojs/ojarraydataprovider'], 
function(PagingDataProviderView,ArrayDataProvider) {
  'use strict';

  var PageModule = function PageModule() {};

  PageModule.prototype.pagingSearchAreaData = function(array) {
    var data = new PagingDataProviderView(new ArrayDataProvider(
    array, {
      idAttribute: 'id'
    }));
    return data;
  };

  return PageModule;
});
