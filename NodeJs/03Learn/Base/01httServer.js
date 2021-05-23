--Learn Js folder

const http =require("http");

const server=http.createServer((req, res)=>{
    console.log(req);
    // process.exit(); //-- don't use 
});

server.listen(3000);
