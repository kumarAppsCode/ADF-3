now working in web url

var fs=require("fs");
var http=require("http");

// var dat=fs.stat("demo.txt", function(err, dataStatus){
//     if(err){
//         console.log("=>"+err);
//     }
//     console.log("==>"+dataStatus.isFile());
//     console.log(dataStatus);
// });

var sta= http.createServer(function(req, res){

    fs.stat("demo.txt", function(err, status){
        if(err){
            console.error(err);
        }
        res.write("Status");
        res.write(status.isFile);
        res.end();
    });

}).listen(8080);
