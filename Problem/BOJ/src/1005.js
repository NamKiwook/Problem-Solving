const fs = require('fs');
const inputData = fs.readFileSync('./dev/1005').toString().split(/\r\n|\r|\n/);

let inputCount = 0;

const T = inputData[inputCount++];

for(let i = 0; i < T; i++){
  const N = inputData[inputCount].split(' ')[0];
  const K = inputData[inputCount++].split(' ')[1];
  const D = inputData[inputCount++].split(' ');
  let orderInfo = [];
  let inDegree = [];

  for(let j = 0; j < N; j++) {
    orderInfo[j] = [];
    inDegree[j] = 0;
  }
  for(let j = 0; j < K; j++) {
    const X = inputData[inputCount].split(' ')[0] - 1;
    const Y = inputData[inputCount++].split(' ')[1] - 1;
    inDegree[Y]++;
    orderInfo[X].push(Y);
  }
  const targetIndex = inputData[inputCount++] - 1;

  let orderQueue = [];
  let buildTime = [];

  for(let j = 0; j < N; j++) {
    buildTime[j] = 0;
    if(inDegree[j] === 0) {
      orderQueue.push(j);
    }
  }

  while(orderQueue.length !== 0) {
    let index = orderQueue.shift();
    for(let j = 0; j < orderInfo[index].length; j++){
      let target = orderInfo[index][j];
      if(--inDegree[target] === 0) {
        orderQueue.push(target);
      }
      buildTime[target] = Math.max(buildTime[target], buildTime[index] + parseInt(D[index]));
    }
  }

  console.log(buildTime[targetIndex] + parseInt(D[targetIndex]));
}

