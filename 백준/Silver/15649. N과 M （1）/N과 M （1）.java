import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int[] output;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = i+1;
        }
        output = new int[M];
        visited = new boolean[N];

        permutation(0, M);
    }

    public static void permutation(int level, int r){
        if(level == r){
            for(int i = 0; i < r; i++){
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i< arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                output[level] = arr[i];
                permutation(level+1, r);
                visited[i] = false;
            }
        }
    }

}