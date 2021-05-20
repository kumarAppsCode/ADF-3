var http=require('http');

http.createServer(function(req, res){
    res.writeHead(200, {'Content-type':'text/plain'});
    res.write("Hi Dinesh");
    res.end("");
}).listen(8080)
****************************************
http://localhost:8080/
****************************************
