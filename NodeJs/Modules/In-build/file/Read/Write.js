var fs=require("fs");

var http=require("http");

var data=fs.writeFile("demo.txt", "ABC", function(err){
        if(err){
            console.error(err);
        }
})


var da=fs.readFile("demo.txt", function(err, datas){
    if(err){
        console.error(err)
    }
    console.log("R===>"+datas)
})


var http= http.createServer(function(req, res){
    var das=fs.writeFile("demo.txt", "Web XYZ", function(err){
        if(err){
            return console.error(err);
        }
        res.write("Done");
        res.end();
    })
}).listen(8080)

