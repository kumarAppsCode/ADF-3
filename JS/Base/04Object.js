// const person={
//     name:"dinesh",
//     aget:35,
//     greet:()=>{
//         console.log("Hi This is "+this.name);
//     }
// };

// person.greet();

// const person={
//     name:"dinesh",
//     aget:35,
//     greet:function(){
//         console.log("Hi This is "+this.name);
//     }
// };

// person.greet();
// console.log(person);

const person={
    name:"dinesh",
    aget:35,
    greet(){
        console.log("Hi This is "+this.name);
    }
};

person.greet();
