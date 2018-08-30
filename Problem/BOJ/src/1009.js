var fs = require('fs');
var inputData = fs.readFileSync('./dev/1009').toString().split(/\r\n|\r|\n/);

var T = inputData[0];

for(var i = 1; i <= T; i++){
  var a = parseInt(inputData[i].split(' ')[0]) % 10;
  var b = parseInt(inputData[i].split(' ')[1]);
  var result = 1;
  for(var j = 0; j < b; j++) {
    result = (result * a) % 10;
  }
  if(result === 0) {
    console.log(10);
  } else {
    console.log(result);
  }
}

