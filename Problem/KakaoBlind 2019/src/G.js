console.log(solution([[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,4,0,0,0],[0,0,0,0,0,4,4,0,0,0],[0,0,0,0,3,0,4,0,0,0],[0,0,0,2,3,0,0,0,5,5],[1,2,2,2,3,3,0,0,0,5],[1,1,1,0,0,0,0,0,0,5]]));
function solution(board) {
  let answer = 0;
  let topArr = [];
  for(let i = 0; i < board.length; i++) {
    for(let j = 0; j < board[i].length; i++) {
      if(board[i][j] > 0 && topArr[]) {

      }
    }
  }
  return answer;
}
