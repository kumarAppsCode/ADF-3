const http=require('http');

http.createServer((req, res)=>{
    const url=req.url;
    if(url ==='/'){
        res.write('<html>');
        res.write('<head><Title>My Page</Title></head>');
        res.write('<body><form method="post" action="/message"><input type="text" name="message"><button type="submit">Submit</button></form></body>')
        res.write('</html>');
        return res.end();
    }
    res.write("<html>");
    res.write("<head><Title>My Page</Title></head>");
    res.write("<body>Hi Dinesh</body>");
    res.write("</html>");
    return res.end();


}).listen(3000);

