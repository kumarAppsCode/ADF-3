var http=require("http");
var fs=require("fs");
var url=require("url");

http.createServer(function(req, res){
    var weblink=url.parse(req.url, true);
    var filepath="."+weblink.pathname;

    fs.readFile("abc.html", function(err, data){
        if(err){
            res.writeHead("400", {"Content-type":"text/html"});
            res.end("File not found");
        }
        res.writeHead("200", {"Content-type":"text/html"});
        res.write(data);
        res.end();

    });



}).listen(8080);
