define([], function() {
  'use strict';

  var PageModule = function PageModule() {};
***************************************************************
  PageModule.prototype.sumOfDays=function(age, age5){
    return age+age5;
  }
***************************************************************
  return PageModule;
});
