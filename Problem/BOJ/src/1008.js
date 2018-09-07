const fs = require('fs');
const inputData = fs.readFileSync('./dev/1008').toString().split(/\r\n|\r|\n/);

const A = inputData[0].split(' ')[0];
const B = inputData[0].split(' ')[1];


console.log(A/B);