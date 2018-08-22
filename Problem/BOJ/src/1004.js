var fs = require('fs');
var inputData = fs.readFileSync('./dev/1004').toString().split(/\r\n|\r|\n/);

function distance(x1,y1,x2,y2) {
  return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
}
var inputCount = 0;

var T = parseInt(inputData[inputCount++]);

for(var j = 0; j < T; j++) {
  var x1 = parseInt(inputData[inputCount].split(' ')[0]);
  var y1 = parseInt(inputData[inputCount].split(' ')[1]);
  var x2 = parseInt(inputData[inputCount].split(' ')[2]);
  var y2 = parseInt(inputData[inputCount++].split(' ')[3]);

  var n = parseInt((inputData[inputCount++]));

  var result = 0;

  for (var i = 0; i < n; i++) {
    var cx = parseInt(inputData[inputCount].split(' ')[0]);
    var cy = parseInt(inputData[inputCount].split(' ')[1]);
    var r = parseInt(inputData[inputCount++].split(' ')[2]);

    var startDistance = distance(x1, y1, cx, cy);
    var endDistance = distance(x2,y2,cx,cy);
    if((startDistance < r * r && endDistance > r * r) || (endDistance < r * r && startDistance > r * r)) {
      result++;
    }
  }

  console.log(result);
}