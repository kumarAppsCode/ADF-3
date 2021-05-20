var fs=require("fs");

var data=fs.readFileSync('demo.txt');
console.log('sync1 : '+data);
console.log("End");

var data=fs.readFile('demo.txt', function(err, data){
    if(err){
        return console.error(err);
    }
    console.log("Async data: "+data);
});

var data=fs.readFileSync('demo.txt');
console.log('sync 2: '+data);
console.log("End");

