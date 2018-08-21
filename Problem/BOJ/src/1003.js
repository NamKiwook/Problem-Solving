var fs = require('fs');
var inputData = fs.readFileSync('./dev/1003').toString().split(/\r\n|\r|\n/);

var T = parseInt(inputData[0]);

for(var i = 1; i <= T; i++) {
  var N = parseInt(inputData[i]);
  var before = { one: 0, zero: 1 };
  var after = {one: 1, zero: 0};
  for(var j = 1; j < N; j++) {
    var temp = after;
    after = {one: before.one + after.one, zero: before.zero + after.zero};
    before = temp;
  }
  if(N === 0) {
    console.log(before.zero + ' ' + before.one);
  } else {
    console.log(after.zero + ' ' + after.one);
  }
}