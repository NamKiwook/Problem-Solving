function solution(board) {
  let answer = 0;
  let searchedInfo;
  while(searchedInfo = searchErasable(board)) {
    answer++;
    eraseBlock(board,searchedInfo);
  }
  return answer;
}

function searchErasable(board) {
  for(let i = 0 ; i < board[0].length; i++) {
    for(let j = 0; j < board.length; j++) {
      if(board[j][i] > 0) {
        let blockNum = board[j][i];
        if( j >= 2 && i <= board[0].length - 1) { //check _l range
          if( board[j][i+1] === blockNum && board[j-1][i+1] === blockNum && board[j-2][i+1] === blockNum) { //check _l shape
            return { shape : '_l', x : j, y : i };
          }
        }
        if( j >= 2 && i >= 1) { //check l_ range
          if( board[j][i-1] === blockNum && board[j-1][i-1] === blockNum && board[j-2][i-1] === blockNum) { //check l_ shape
            return { shape : 'l_', x : j, y : i };
          }
        }
        if( j >= 1 && i <= board[0].length - 2 ) { //check ___l range
          if( board[j][i+1] === blockNum && board[j][i+2] === blockNum && board[j-1][i+2] === blockNum) { //check ___l shape
            for(let k = j - 1; k >= 0; k--) { //check upper side
              if( board[k][i+1] > 0) break;
              if( k === 0) return { shape : '___l', x : j, y : i };
            }
          }
        }
        if( j >= 1 && i >= 1 && i <= board[0].length - 1 ) { //check l___ range
          if( board[j][i-1] === blockNum && board[j-1][i-1] === blockNum && board[j][i+1] === blockNum) { //check l___ shape
            for(let k = j - 1; k >= 0; k--) { //check upper side
              if( board[k][i+1] > 0) break;
              if( k === 0)  return { shape : 'l___', x : j, y : i };
            }
          }
        }
        if( j >= 1 && i <= board[0].length - 2 ) { //check _l_ range
          if( board[j][i+1] === blockNum && board[j-1][i+1] === blockNum && board[j][i+2] === blockNum) { //check _l_ shape
            for(let k = j - 1; k >= 0; k--) { //check upper side
              if( board[k][i+2] > 0) break;
              if( k === 0) return { shape : '_l_', x : j, y : i };
            }
          }
        }
        break;
      }
    }
  }
  return false;
}

function eraseBlock(board, info) {
  switch(info.shape) {
    case '_l' :
      board[info.x][info.y] = 0;
      board[info.x][info.y + 1] = 0;
      board[info.x-1][info.y + 1] = 0;
      board[info.x-2][info.y + 1] = 0;
      break;
    case 'l_' :
      board[info.x][info.y] = 0;
      board[info.x][info.y - 1] = 0;
      board[info.x-1][info.y - 1] = 0;
      board[info.x-2][info.y - 1] = 0;
      break;
    case '___l' :
      board[info.x][info.y] = 0;
      board[info.x][info.y + 1] = 0;
      board[info.x][info.y + 2] = 0;
      board[info.x-1][info.y + 2] = 0;
      break;
    case 'l___' :
      board[info.x][info.y] = 0;
      board[info.x][info.y - 1] = 0;
      board[info.x-1][info.y - 1] = 0;
      board[info.x][info.y + 1] = 0;
      break;
    case '_l_' :
      board[info.x][info.y] = 0;
      board[info.x][info.y + 1] = 0;
      board[info.x-1][info.y + 1] = 0;
      board[info.x][info.y + 2] = 0;
      break;
    default :
      break;
  }
}