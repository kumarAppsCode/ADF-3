require()
------------------------------
function(x,y){
    return x+y
}
------------------------------
Above one will have multiple funcation, So we need to use export key word.

exports.function(x,y){
    return x+y
}
------------------------------
Multiple Export will come So, We need to give name
exports.add=function(x,y){
    return x+y
}

exports.sub=function(x,y){
    return x-y
}
------------------------------------------------------------
Next File:
var call=require('./mathcall');
var x=5;
var y=9;
console.log("Add:"+call.add(x,y))
------------------------------------------------------------
