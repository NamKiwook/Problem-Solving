var fs = require('fs');
var inputData = fs.readFileSync('./dev/1012').toString().split(/\r\n|\r|\n/);

var inputCount = 0;
var T = parseInt(inputData[inputCount++]);

function Point(y, x) {
  this.x = x || 0;
  this.y = y || 0;
}

function searchSize(isVisit, farm, j, k) {
  var queue = [];
  isVisit[j][k] = 1;
  queue.push(new Point(j,k));
  while(queue.length !== 0) {
    var point = queue.pop();
    if(point.y - 1 >= 0) {
      if(farm[point.y-1][point.x] === 1 && isVisit[point.y-1][point.x] !== 1) {
        isVisit[point.y-1][point.x] = 1;
        queue.push(new Point(point.y - 1, point.x));
      }
    }
    if(point.y + 1 < isVisit.length) {
      if(farm[point.y+1][point.x] === 1 && isVisit[point.y+1][point.x] !== 1) {
        isVisit[point.y+1][point.x] = 1;
        queue.push(new Point(point.y + 1, point.x));
      }
    }
    if(point.x - 1 >= 0) {
      if(farm[point.y][point.x-1] === 1 && isVisit[point.y][point.x-1] !== 1) {
        isVisit[point.y][point.x-1] = 1;
        queue.push(new Point(point.y, point.x - 1));
      }
    }
    if(point.x + 1 < isVisit[point.y].length) {
      if(farm[point.y][point.x+1] === 1 && isVisit[point.y][point.x+1] !== 1) {
        isVisit[point.y][point.x+1] = 1;
        queue.push(new Point(point.y, point.x + 1));
      }
    }
  }
}

for(var i = 0; i < T; i++) {
  var M = parseInt(inputData[inputCount].split(' ')[0]);
  var N = parseInt(inputData[inputCount].split(' ')[1]);
  var K = parseInt(inputData[inputCount++].split(' ')[2]);
  var farm = [];
  var isVisit = [];
  for(var j = 0; j < N; j++) {
    farm.push(new Array(M));
    isVisit.push(new Array(M));
  }
  for(var j = 0; j < K; j++) {
    var X = parseInt(inputData[inputCount].split(' ')[0]);
    var Y = parseInt(inputData[inputCount++].split(' ')[1]);
    farm[Y][X] = 1;
  }
  var result = 0;
  for(var j = 0; j < N; j++) {
    for(var k = 0; k < M; k++) {
      if(isVisit[j][k] || !farm[j][k]) continue;
      result++;
      searchSize(isVisit, farm, j, k);
    }
  }
  console.log(result);
}