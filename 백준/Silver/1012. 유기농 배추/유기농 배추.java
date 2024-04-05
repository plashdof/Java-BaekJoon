import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static class Pair {

        int x;
        int y;

        Pair(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

    static int M;
    static int N;
    static int K;

    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] inputs = br.readLine().split(" ");
            M = Integer.parseInt(inputs[0]);
            N = Integer.parseInt(inputs[1]);
            K = Integer.parseInt(inputs[2]);

            board = new int[N][M];
            int count = 0;

            for (int j = 0; j < K; j++) {
                String[] input = br.readLine().split(" ");
                int X = Integer.parseInt(input[0]);
                int Y = Integer.parseInt(input[1]);
                board[Y][X] = 1;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (board[j][k] == 1 ) {
                        count++;
                        bfs(new Pair(k, j));
                    }
                }
            }

            bw.write(String.valueOf(count));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static void bfs(Pair start) {
        Deque<Pair> que = new LinkedList<>();
        que.offer(start);

        while (!que.isEmpty()) {
            Pair now = que.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = now.y + dy[i];
                int nextX = now.x + dx[i];

                if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
                if(board[nextY][nextX] == 0) continue;

                board[nextY][nextX] = 0;
                que.offer(new Pair(nextX, nextY));
            }
        }
    }
}