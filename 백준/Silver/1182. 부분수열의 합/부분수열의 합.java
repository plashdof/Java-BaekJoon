import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static List<Integer> list;

    static int S;
    static int count = 0;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        S = Integer.parseInt(inputs[1]);


        list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        for(int i = 1; i <= N; i++){
            visited = new boolean[N];
            combination(0,0,N, i);
        }
        System.out.print(count);
    }

    public static void combination(int start, int sum, int n, int r) {

        if(r == 0){
            if (sum == S) {
                count++;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(i + 1, sum + list.get(i), n, r-1);
                visited[i] = false;
            }
        }
    }

}