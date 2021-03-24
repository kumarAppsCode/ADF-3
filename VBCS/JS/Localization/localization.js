Adding the following to the app-flow.json file to define localization:

 
  "localization": {
  "locale": "{{ window.localStorage.getItem('vbcs.languageSwitcherApplication.locale') || 'en' }}"
}

************************************************************************************************************************

A JavaScript method used to set the variable we keep on the machine to store default locale:

PageModule.prototype.setAppLanguage = function(selectedLocale){
  if (selectedLocale)  {
    window.localStorage.setItem('vbcs.languageSwitcherApplication.locale',selectedLocale);
  }
}
************************************************************************************************************************
