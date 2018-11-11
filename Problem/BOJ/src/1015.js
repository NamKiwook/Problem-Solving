var fs = require('fs');
var inputData = fs.readFileSync('./dev/1015').toString().split(/\r\n|\r|\n/);

var inputArray = inputData[1].split(' ').map(function(n) { return parseInt(n); });
var sortedArray = inputData[1].split(' ').map(function(n) { return [parseInt(n), 0]; });

sortedArray.sort(function(a,b) {
  return a[0] - b[0];
});

var result = '';

for(var i = 0; i < inputArray.length; i++) {
  for(var j = 0; j < sortedArray.length; j++) {
    if(inputArray[i] === sortedArray[j][0] && sortedArray[j][1] === 0) {
      sortedArray[j][1] = 1;
      result = result + j + ' ';
      break;
    }
  }
}

console.log(result);

