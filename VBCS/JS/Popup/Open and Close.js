define([], function() {
  'use strict';

  var PageModule = function PageModule() {};

  /**
   *
   * @param {String} arg1
   * @return {String}
   */
  PageModule.prototype.onOpenPopup = function (arg1) {
    document.getElementById("dialog1").open();
  };

  /**
   *
   * @param {String} arg1
   * @return {String}
   */
  PageModule.prototype.onClosePopup = function (arg1) {
    document.getElementById("dialog1").close();
  };

  return PageModule;
});
