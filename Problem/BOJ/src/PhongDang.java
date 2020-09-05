import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Math.max;

public class PhongDang {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLineContent = br.readLine().split(" ");
        int size = Integer.parseInt(firstLineContent[0]);
        int distance = Integer.parseInt(firstLineContent[1]);
        int[][] field = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] lineContent = br.readLine().split(" ");
            for (int j = 0; j < lineContent.length; j++) {
                field[i][j] = Integer.parseInt(lineContent[j]);
            }
        }
        int[][][] boundedField;
        int result = 0;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                boundedField = new int[distance + 1][size][size];
                if (field[x][y] != 1) {
                    for (int i = 0; i <= distance; i++) {
                        if (i == 0) {
                            boundedField[i][x][y] = 1;
                        } else {
                            for (int j = 0; j < size; j++) {
                                for (int k = 0; k < size; k++) {
                                    if (boundedField[i - 1][j][k] == 1) {
                                        boundedField[i][j][k] = 1;
                                        if (j - 1 >= 0 && j - 1 < size) {
                                            if (field[j - 1][k] != 1) {
                                                boundedField[i][j - 1][k] = 1;
                                            }
                                        }
                                        if (k + 1 < size) {
                                            if (field[j][k + 1] != 1) {
                                                boundedField[i][j][k + 1] = 1;
                                            }
                                        }
                                        if (j + 1 < size) {
                                            if (field[j + 1][k] != 1) {
                                                boundedField[i][j + 1][k] = 1;
                                            }
                                        }
                                        if (k - 1 >= 0 && k - 1 < size) {
                                            if (field[j][k - 1] != 1) {
                                                boundedField[i][j][k - 1] = 1;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                int count = 0;
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (boundedField[distance][i][j] == 1) {
                            count += 1;
                        }
                    }
                }
                result = max(result, count);
            }
        }
        System.out.println(result);
    }
}
