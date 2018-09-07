var fs = require('fs');
var inputData = fs.readFileSync('./dev/1001').toString().split(/\r\n|\r|\n/);

var A = inputData[0].split(' ')[0];
var B = inputData[0].split(' ')[1];

console.log(A-B);