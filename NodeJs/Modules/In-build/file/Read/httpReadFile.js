var http=require("http");
var fs=require("fs");


http.createServer(function(req, res){
    var data=fs.readFile('demo.txt', function(err, data){
        if(err){
            return console.error(err);
        }
        console.log("Async data: "+data);
        res.write(data);
        res.end();
    });
   
}).listen(8080);

