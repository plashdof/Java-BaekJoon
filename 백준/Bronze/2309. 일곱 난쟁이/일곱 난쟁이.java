import java.io.*;
import java.util.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        boolean[] visited = new boolean[9];

        for(int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        combination(arr, visited, 0, 9, 7);

    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r){
        if(r == 0){
            check(arr, visited, n);
            return;
        }

        for(int i = start; i < n; i++){
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static void check(int[] arr, boolean[] visited, int n) {
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(visited[i]) {
                result.add(arr[i]);
                sum += arr[i];
            }
        }

        if(sum == 100){
            Collections.sort(result);
            for(int item: result){
                System.out.println(item);
            }
            System.exit(0);
        }
    }
}