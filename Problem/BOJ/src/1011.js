var fs = require('fs');
var inputData = fs.readFileSync('./dev/1011').toString().split(/\r\n|\r|\n/);

var T = parseInt(inputData[0]);

for (var i = 1; i <= T; i++) {
  var x = parseInt(inputData[i].split(' ')[0]);
  var y = parseInt(inputData[i].split(' ')[1]);
  var length = y - x;

  var maxK = Math.floor(Math.sqrt(length));
  var remainder = length - (maxK * maxK);
  var result = 2 * maxK - 1;

  if (remainder > 0) {
    result += Math.ceil(remainder / maxK);
  }
  console.log(result);

}