var fs = require('fs');
var inputData = fs.readFileSync('./dev/1018').toString().split(/\r\n|\r|\n/);

var N = parseInt(inputData[0].split(' ')[0]);
var M = parseInt(inputData[0].split(' ')[1]);

var board = [];

for(var i = 1; i <= N; i++) {
  board.push(inputData[i].split(''));
}

var minimum = 2501;

for(var i = 0; i <= N - 8; i++) {
  for(var j = 0; j <= M - 8; j++) {
    var typeA = 0;
    var typeB = 0;
    for(var k = i; k < i + 8; k++) {
      for(var l = j; l < j + 8; l++) {
        if((k+l) % 2 === 1) {
          if(board[k][l] === 'W') {
            typeA++;
          }else {
            typeB++;
          }
        } else {
          if(board[k][l] === 'B') {
            typeA++;
          }else {
            typeB++;
          }
        }
      }
    }
    if(minimum > typeA) minimum = typeA;
    if(minimum > typeB) minimum = typeB;
  }
}
console.log(minimum);
