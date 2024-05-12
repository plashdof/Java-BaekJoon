import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int[] arr;
    static int[] output;
    static int M;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        arr = new int[N];
        output = new int[M];

        for(int i = 0; i < N; i++){
            arr[i] = i + 1;
        }

        backtracking(0);
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    public static void backtracking(int level){

        if(level == M){
            for (int j : output) {
                sb.append(j).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
            return;
        }

        for (int j : arr) {
            if (level > 0) {
                if (output[level - 1] <= j) {
                    output[level] = j;
                    backtracking(level + 1);
                }
            } else {
                output[level] = j;
                backtracking(level + 1);
            }
        }

    }
}