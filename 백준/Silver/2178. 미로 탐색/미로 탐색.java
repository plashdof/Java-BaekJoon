import java.io.*;
import java.util.*;

public class Main {

    static class Pair {
        int x;
        int y;

        Pair(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

    static int[][] board;

    static int n;
    static int m;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();

            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
            }
        }

        Pair temp = new Pair(0,0);
        bfs(temp);
        System.out.print(board[n-1][m-1]);
    }

    public static void bfs(Pair start) {
        Queue<Pair> que = new LinkedList<>();
        que.offer(start);
        visited[start.y][start.x] = true;

        while(!que.isEmpty()){
            Pair now = que.poll();

            for(int i = 0; i < 4; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= m || nextY >= n)
                    continue;
                if(visited[nextY][nextX] || board[nextY][nextX] == 0)
                    continue;

                que.offer(new Pair(nextX, nextY));
                board[nextY][nextX] = board[now.y][now.x] + 1;
                visited[nextY][nextX] = true;
            }
        }
    }
}