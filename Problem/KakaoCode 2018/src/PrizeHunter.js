var fs = require('fs');
var FIRST = [[1,3,6,10,15,21],[5000000,3000000,2000000,500000,300000,100000]];
var SECOND = [[1,3,7,15,31],[5120000,2560000,1280000,640000,320000]];

var inputData = fs.readFileSync('./dev/stdinA').toString().split(/\r\n|\r|\n/);

for(var i = 1 ; i <= inputData[0]; i++) {
    var result = 0;
    var firstFestival = inputData[i].split(' ')[0];
    var secondFestival = inputData[i].split(' ')[1];

    for(var j = 0; j < FIRST[0].length; j++ ){
        if(FIRST[0][j] >= firstFestival && firstFestival != 0) {
            result += FIRST[1][j];
            break;
        }
    }
    for(var j = 0; j < SECOND[0].length; j++ ){
        if(SECOND[0][j] >= secondFestival  && secondFestival != 0) {
            result += SECOND[1][j];
            break;
        }
    }
    console.log(result);
}