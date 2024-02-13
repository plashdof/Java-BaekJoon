import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String strs = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = strs.charAt(j);
            }
        }

        int answer = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // 가로 swaping
                char temp = board[i][j];
                board[i][j] = board[i][j + 1];
                board[i][j + 1] = temp;

                int result = checkBoard(board, n);
                if (answer < result) answer = result;

                // 원래대로
                temp = board[i][j];
                board[i][j] = board[i][j + 1];
                board[i][j + 1] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // 세로 swaping
                char temp = board[j][i];
                board[j][i] = board[j + 1][i];
                board[j + 1][i] = temp;

                int result = checkBoard(board, n);
                if (answer < result) answer = result;

                // 원래대로
                temp = board[j][i];
                board[j][i] = board[j + 1][i];
                board[j + 1][i] = temp;
            }
        }

        System.out.print(answer);
    }

    public static int checkBoard(char[][] board, int n) {

        // 가로 max check
        int max = -1;
        for (int i = 0; i < n; i++) {

            int count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    count++;
                    if (max < count) max = count;
                } else {
                    count = 1;
                }
            }
        }

        // 세로 max check
        for (int i = 0; i < n; i++) {

            int count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (board[j][i] == board[j + 1][i]) {
                    count++;
                    if (max < count) max = count;
                } else {
                    count = 1;
                }
            }
        }

        return max;
    }
}