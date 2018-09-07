var fs = require('fs');
var inputData = fs.readFileSync('./dev/1010').toString().split(/\r\n|\r|\n/);

function combination(n, r) {
  var result = 1;
  for(var i = 0; i < r; i++){
    result *= (n - i) / (r - i);
  }
  return result.toFixed(0);
}

var T = parseInt(inputData[0]);

for(var i = 1; i <= T; i++) {
  var N = parseInt(inputData[i].split(' ')[0]);
  var M = parseInt(inputData[i].split(' ')[1]);
  console.log(combination(M,N));
}


