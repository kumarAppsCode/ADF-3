const http=require('http');
const fs=require('fs');

http.createServer((req, res)=>{
    const url=req.url;
    const method=req.method;
    if(url ==='/'){
        res.write('<html>');
        res.write('<head><Title>My Page</Title></head>');
        res.write('<body><form method="post" action="/message"><input type="text" name="message"><button type="submit">Submit</button></form></body>')
        res.write('</html>');
        return res.end();
    }
    console.log(method);

    if(url==='/message' && method==='POST'){
        // write file
        console.log('===')
        fs.writeFileSync("message.txt", "dummy");
        res.statusCode=305;
        res.setHeader('Location','/');
        return res.end();
    }

    res.write("<html>");
    res.write("<head><Title>My Page</Title></head>");
    res.write("<body>Hi Dinesh</body>");
    res.write("</html>");
    return res.end();


}).listen(3000);

