// hobby=[];

// hobby=["Sports", "watching TV", 1, {name:"BE", year:2021}]
// console.log(hobby);

const hobby=["Sports", "watching TV"];
for (let a of hobby) {
    console.log(a);
}


// const copyArray=hobby.slice(); 
// console.log(copyArray);

const copyArray1=[hobby];
console.log(copyArray1);

// spread operation
const copyArray=[... hobby];
console.log(copyArray);

// Reset Operation
// const toArray=(arg1, arg2, arg3)=>{
//     return [arg1,arg2,arg3];
// }
// console.log(toArray(1,2,3, 4));

const toArray=(...Arg)=>{
    return Arg;
}
console.log(toArray(1,2,3,4));
