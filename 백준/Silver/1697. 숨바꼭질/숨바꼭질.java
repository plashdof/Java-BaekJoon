import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int[] board = new int[100001];
    static boolean[] visited = new boolean[100001];
    static int N;
    static int K;

    static int[] dx = {1, -1, 2};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);
        if(N==K) System.out.print(0);
        else bfs();
    }

    public static void bfs(){
        Deque<Integer> que = new LinkedList<>();
        que.offer(N);

        while(!que.isEmpty()){
            int now = que.poll();

            for(int i = 0; i < 3; i++){
                int next;

                if(i == 2){
                    next = now * dx[i];
                } else {
                    next = now + dx[i];
                }

                if(next < 0 || next >= 100001 || visited[next]) continue;

                visited[next] = true;
                if(next == K){
                    System.out.print(board[now] + 1);
                    System.exit(0);
                } else {
                    board[next] = board[now] + 1;
                    que.offer(next);
                }
            }
        }
    }
}