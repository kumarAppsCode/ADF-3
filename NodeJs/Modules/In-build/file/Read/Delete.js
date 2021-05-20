var fs=require("fs");
var http=require("http");

// var ReNameFile=fs.unlink("demo.txt", "demos.txt", function(err){
//     if(err){
//         return console.error(err);
//     }
//     console.log("Rename completed");
// });


var fileRename=http.createServer(function(req, res){
    fs.unlink("demo.txt", function(err){
        if(err){
            return console.error(err);
        }
        res.write("rename Completed");
        res.end();
    })
}).listen(8080);
