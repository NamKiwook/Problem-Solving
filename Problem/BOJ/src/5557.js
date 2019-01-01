var fs = require('fs');
var inputData = fs.readFileSync(__dirname +'/dev/5557').toString().split(/\r\n|\r|\n/);

var n = parseInt(inputData[0]);

var nums = inputData[1].split(" ");
var DP = [];


for(var i = 0; i < nums.length; i++) {
  nums[i] = parseInt(nums[i]);
  DP.push([0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]);
}

DP[0][nums[0]]++;

for(var i = 1; i < nums.length - 1; i++) {
  for(var j = 0; j <= 20; j++) {
    if(DP[i - 1][j] === 0) continue;
    if(j + nums[i] <= 20)
      DP[i][j + nums[i]] += DP[i - 1][j];
    if(j - nums[i] >= 0)
      DP[i][j - nums[i]] += DP[i - 1][j];
  }
}

console.log(DP[nums.length - 2][nums[nums.length - 1]]);