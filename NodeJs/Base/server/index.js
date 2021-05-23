const express = require('express');
const { BIND_IN, STRING } = require('oracledb');
const oracledb = require('oracledb');
const app = express();
const port = 8080;

async function selectAllEmp(req, res) {
    try 
    {
        connection= await oracledb.getConnection({
                user : "****",
                password : "****",
                connectString : "0000:1500/************"
        });
        console.log('connected to database');
        result = await connection.execute("SELECT ID, FIRST_NAME, LAST_NAME, EMAIL, DEP_ID, JOIN_DATE FROM EMPLOYEE");
    } catch (error) 
    {
            return console.log(error.message);        
    } finally 
    {
            if (connection) {
            try {
                // Always close connections
                await connection.close(); 
                console.log('close connection success');
            } catch (err) {
                console.error(err.message);
            }
            }
        if(result.rows.length==0){
            return   res.send("no data found");
        }else{
                return res.send(result.rows);
        }
    }
}

//get /employess
app.get('/emp', function (req, res) {
    let id=req.query.id;

    if(id){
        if(isNaN(id)){
    
            return res.send("Query Param is not a number");
        }
        filterEmployeeById(req, res, id);
    }else{
        selectAllEmp(req, res);
    }
        
})

//************************************************

// app.get("/emp", function (req, res){
    
// })

async function filterEmployeeById(req, res, id){
    try {
        connection=await oracledb.getConnection({
                user : "****",
                password : "****",
                connectString : "0000:1500/************"
        });
        console.log("DB Connected id"+ id);
        result= await connection.execute("SELECT * from EMPLOYEE where ID=:id",
                        {
                            id:{
                                type:STRING,
                                val:id,
                                dir:BIND_IN
                               }
                        }
                    );
        console.log("result"+result);
    } catch (error) {
        console.log("Catch==1");
        return res.send(error.message);        
    }finally {
        console.log(result);
        if(result.rows.length ==0){
            return res.send("No Data Found");
        }else{
           return res.send(result.rows); 
        }
            if(connection){
                try {
                    console.log("Catch==2");
                    await connection.close();
                } catch (error) {
                    console.log("Catch==3");
                    return console.error(error.message);
                }                
            }
    }
}



app.listen(port, function(err){
    if(err){
        console.log(err.message);
    }
    console.log("nodeOracleRestApi app listening on port %s!", port);
})
