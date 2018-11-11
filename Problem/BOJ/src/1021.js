var fs = require('fs');
var inputData = fs.readFileSync('./dev/1021').toString().split(/\r\n|\r|\n/);

var N = parseInt(inputData[0].split(' ')[0]);
var M = parseInt(inputData[0].split(' ')[1]);

var hopeList = inputData[1].split(' ').map(function(n) { return parseInt(n) - 1; });

var result = 0;
var head = 0;
var list = [];

for(var i = 0; i < N; i++) {
  list.push(1);
}

for(var i = 0; i < M; i++) {
  var target = hopeList[i];
  if(target !== head ) {
    var rLen = 0;
    var lLen = 0;
    var mLen = N;
    for (var j = 1; j < N; j++) {
      var head2R = head + j;
      var head2L = head - j;
      if(head2R >= N) {
        head2R -= N;
      }
      if(head2R === target && mLen > rLen) {
        mLen = rLen + 1;
      } else if(list[head2R] !== -1){
        rLen++;
      }

      if(head2L < 0) {
        head2L += N;
      }
      if(head2L === target && mLen > lLen) {
        mLen = lLen + 1;
      } else if(list[head2L] !== -1){
        lLen++;
      }

    }
    result += mLen;
  }
  list[target] = -1;
  head = target;
  for(var j = 0; j < N; j++) {
    if(list[head] !== -1) break;
    head++;
    if(head >= N) {
      head -= N;
    }
  }
}

console.log(result);