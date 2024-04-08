import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {


    static int[][] board;
    static int N;
    static int minusCount = 0;
    static int plusCount = 0;
    static int zeroCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for(int i = 0; i < N; i++){

            List<Integer> list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());

            for(int j = 0; j < N; j++){
                board[i][j] = list.get(j);
            }
        }

        recursion(0,0,N);
        System.out.print(minusCount + "\n" + zeroCount + "\n" + plusCount);
    }

    public static void recursion(int startX, int startY, int n){


        int temp = 0;
        boolean flag = false;

        loop : for(int i = startY; i < startY + n; i++){
            for(int j = startX; j < startX + n; j++){
                if(i == startY && j == startX){
                    temp = board[i][j];
                } else {
                    if(temp != board[i][j]){
                        flag = true;
                        break loop;
                    }
                }
            }
        }

        if(flag){
            int size = n / 3;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    recursion(startX + j * size, startY + i * size, size);
                }
            }
        } else {
            if(temp == 0){
                zeroCount++;
            } else if(temp == 1){
                plusCount++;
            } else{
                minusCount++;
            }
            return;
        }
    }
}