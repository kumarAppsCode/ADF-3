var fs=require("fs");

var http=require("http");

// var openFile=fs.open("demo_file.txt", "w+", function(err){
//     if(err){
//         console.error("=>"+err);
//     }
// })

var fsOpen=http.createServer(function(req, res){
    fs.open("abc.txt", "w+", function(err){
        if(err){
            console.error(err);
        }
        res.write("File Open");
        res.end();    
    })
}).listen(8080);
