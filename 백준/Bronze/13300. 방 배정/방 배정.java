import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[7][2];

        String[] strs = br.readLine().split(" ");
        int N = Integer.parseInt(strs[0]);
        int K = Integer.parseInt(strs[1]);

        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            int gender = Integer.parseInt(input[0]);
            int grade = Integer.parseInt(input[1]);

            board[grade][gender] += 1;
        }

        int count = 0;

        for(int i = 1; i <= 6; i++){
            for(int j = 0; j <= 1; j++){
                if(board[i][j] != 0){
                    if(board[i][j] % K == 0){
                        count += board[i][j] / K;
                    } else{
                        count += (board[i][j] / K) + 1;
                    }
                }
            }
        }

        System.out.print(count);

    }
}
