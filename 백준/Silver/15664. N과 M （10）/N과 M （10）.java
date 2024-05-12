import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static int M;
    static int N;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        arr = new int[N];
        visited = new boolean[N];

        String[] items = br.readLine().split(" ");
        for (int i = 0; i < items.length; i++) {
            arr[i] = Integer.parseInt(items[i]);
        }
        Arrays.sort(arr);

        backtracking(0,0);
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    public static void backtracking(int start, int level) {

        if (level == M) {
            for(int i = 0; i < arr.length; i++){
                if(visited[i]){
                    sb.append(arr[i]).append(" ");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
            return;
        }

        int before = 0;
        for (int i = start; i < N; i++) {
            if (!visited[i] && before != arr[i]) {
                visited[i] = true;
                before = arr[i];
                backtracking(i + 1, level + 1);
                visited[i] = false;
            }
        }

    }
}