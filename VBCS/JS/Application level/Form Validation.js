define([], function () {
  'use strict';

  var AppModule = function AppModule() {};

AppModule.prototype.isFormValid=function(form){
  var tracker=document.getElementById(form);

  if(tracker.isFormValid=="valid"){
    return true;
  }else{
    tracker.showMessage();
    tracker.focusOn("@firstInvalidShow")
    return false;
  }
}


  return AppModule;
});
