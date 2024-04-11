import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {


    static int[] arr;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        visited = new boolean[N];
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        combination(0,0, M);
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    public static void combination(int start, int level, int r) {

        if(level == r){
            for(int i = 0; i < visited.length; i++){
                if(visited[i]){
                    sb.append(arr[i]).append(" ");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
            return;
        }

        for(int i = start; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                combination(i+1,level+1,r);
                visited[i] = false;
            }
        }
    }
}