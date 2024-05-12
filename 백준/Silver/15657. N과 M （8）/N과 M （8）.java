import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int[] arr;
    static int[] output;
    static int M;
    static int N;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        arr = new int[N];
        output = new int[M];

        String[] items = br.readLine().split(" ");
        for (int i = 0; i < items.length; i++) {
            arr[i] = Integer.parseInt(items[i]);
        }
        Arrays.sort(arr);

        backtracking(0);
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    public static void backtracking(int level) {

        if (level == M) {
            for (int item : output) {
                sb.append(item).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(level > 0){
                if(output[level - 1] <= arr[i]){
                    output[level] = arr[i];
                    backtracking(level+1);
                }
            } else {
                output[level] = arr[i];
                backtracking(level + 1);
            }
        }

    }
}