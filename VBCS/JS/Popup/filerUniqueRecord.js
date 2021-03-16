  var PageModule = function PageModule() {};

//*****************************************************// 
PageModule.prototype.unique=function(result){
  var uniqueResult=[];
  var final=[];

  if(result && result.length>0){
    for(var i=0;i<result.length>0; i++){
      if( !uniqueResult[result[i].id]){
        final.push({
          id:result[i].id,
          departmentName:result[i].departmentName
        });
        uniqueResult[result[i].id]=1;
      }
     
    }
  }
  return final;
} 
//*****************************************************// 
