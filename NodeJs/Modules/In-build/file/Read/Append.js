var fs=require("fs");

var http=require("http");

var dat=fs.appendFile("demo.txt"," Whats App",function(err){
    if(err){
        return console.error(err);
    }
    console.log("Append:");
})

var dataRead=fs.readFile("demo.txt", function(err, data){
    if(err){
        console.log("Error"+err);
    }
    console.log("Reading==>"+data);
})

http.createServer(function(req, res){
    var tat=fs.appendFile("demo.txt"," Dinesh", function(err){
        if(err){
            console.log("==1=="+err);
        }
        res.write("Append Completed");
        res.end();
    })
}).listen(8080);


var dataRead=fs.readFile("demo.txt", function(err, data){
    if(err){
        console.log("Error"+err);
    }
    console.log("Reading==>"+data);
})
