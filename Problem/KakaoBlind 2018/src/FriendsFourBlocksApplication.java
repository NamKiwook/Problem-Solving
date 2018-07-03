public class FriendsFourBlocksApplication {
}

class FriendsFourBlocks {
    public int solution(int m, int n, String[] board) {
        int result = 0;
        char[][] inputBoard = new char[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                inputBoard[i][j] = board[i].charAt(j);
            }
        }
        boolean isEnd = false;

        while(!isEnd) {
            boolean[][] clearBoard = new boolean[m][n];

            //전탐색 4Block
            for(int i = 0; i < m-1; i++) {
                for(int j = 0; j < n-1; j++) {
                    char checkBlock = inputBoard[i][j];
                    int sameBlock = 0;
                    if(checkBlock == 'X') continue;
                    for(int k = 0; k <2; k++) {
                        for(int l = 0; l <2; l++) {
                            if(checkBlock == inputBoard[i+k][j+l])
                                sameBlock++;
                        }
                    }
                    if(sameBlock == 4) {
                        for (int k = 0; k < 2; k++) {
                            for (int l = 0; l < 2; l++) {
                                clearBoard[i+k][j+l] = true;
                            }
                        }
                    }
                }
            }
            int countClear = 0;
            //전탐색 보드 비우기
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(clearBoard[i][j]) {
                        inputBoard[i][j] = 'X';
                        countClear++;
                    }
                }
            }
            if(countClear == 0) {
                isEnd = true;
            } else {
                result += countClear;
            }

            //전탐색 보드 내리기
            for(int j = 0; j < n; j++) {
                for(int i= 0; i < m; i++) {
                    if(inputBoard[i][j] == 'X') {
                        for(int k = i; k > 0; k--) {
                            inputBoard[k][j] = inputBoard[k-1][j];
                        }
                        inputBoard[0][j] = 'X';
                    }
                }
            }
        }
        return result;
    }
}
