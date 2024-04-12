import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int[] arr;

    static int[] output;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        arr = new int[N];
        output = new int[M];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        perm(0,M);
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    public static void perm(int level, int M){

        if(level == M){
            for(int i = 0; i < output.length; i++){
                sb.append(output[i]).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
            return;
        }

        for(int i = 0; i < arr.length; i++){
            output[level] = arr[i];
            perm(level+1, M);
        }

    }

}