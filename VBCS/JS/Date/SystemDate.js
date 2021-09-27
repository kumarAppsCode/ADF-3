define([], function() {
  'use strict';

  var PageModule = function PageModule() {};

// 
  PageModule.prototype.systemDate = function() {

    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = today.getFullYear();
    today = dd + '-' + mm + '-' + yyyy;
    return today;
  };

  return PageModule;
});
