var fs = require('fs');
var inputData = fs.readFileSync('./dev/1024').toString().split(/\r\n|\r|\n/);

var N = parseInt(inputData[0].split(' ')[0]);
var L = parseInt(inputData[0].split(' ')[1]);
var n = -1;
var ni = -1;
for(var i = L; i <= 100 && i <= N; i++) {

}
if(n === -1) {
  console.log("-1");
} else {
  var answer = "";
  for (var i = (-1) * Math.ceil(ni / 2) + 1; i <= ni / 2; i++) {
    answer += n + i + " ";
  }
  console.log(answer);
}