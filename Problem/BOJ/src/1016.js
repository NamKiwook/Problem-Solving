var fs = require('fs');
var inputData = fs.readFileSync('./dev/1016').toString().split(/\r\n|\r|\n/);

var min = parseInt(inputData[0].split(' ')[0]);
var max = parseInt(inputData[0].split(' ')[1]);

var sieve = new Array(max - min + 1);

for(var i = 2; i <= Math.sqrt(max); i++) {
  var square = i * i;
  var minSieve = Math.ceil(min / square);
  var maxSieve = Math.floor(max / square);

  for(var j = minSieve; j <= maxSieve; j++) {
    sieve[square * j - min] = 1;
  }
}
var ans = 0;
for(var i = 0; i < sieve.length; i++) {
  if(sieve[i] !== 1) ans++;
}
console.log(ans);