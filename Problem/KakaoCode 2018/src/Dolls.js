var fs = require('fs');
var inputData = fs.readFileSync('./dev/stdinB').toString().split(/\r\n|\r|\n/);

var N = parseInt(inputData[0].split(' ')[0]);
var K = parseInt(inputData[0].split(' ')[1]);

var an = inputData[1].split(' ');
for(var i = 0; i < N; i++) {
    an[i] = parseInt(an[i]);
}

var minimum = 1e18;

for(var i = K; i <= N; i++) {
    for(var j = 0; j <= N - i; j++) {
        var mean = 0;
        for(var k = 0; k < i; k++) {
            mean += an[j+k];
        }
        mean /= i;

        var deviation = 0;
        for(var k = 0; k < i; k++) {
            deviation += (mean - an[j+k]) * (mean - an[j+k]);
        }
        deviation /= i;
        if(minimum > deviation) {
            minimum = deviation;
        }
    }
}

console.log(Math.sqrt(minimum).toFixed(10));