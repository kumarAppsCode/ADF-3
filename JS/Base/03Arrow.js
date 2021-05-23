const name= "dinesh";
let age=20;
const type=false;

// function summary(userName, userAge, userType){

//     return "user: "+userName + "age:"+ userAge + "type: "+ userType;

// }

const summary=(userName, userAge, userType)=>{
    return "user: "+userName + "age:"+ userAge + "type: "+ userType;
}

console.log(summary(name,age,type));

const add=(a,b)=>{
    return a+b;
}
console.log(add(4,8));


const sub =()=>{
    return 5-7;
};
console.log(sub());
