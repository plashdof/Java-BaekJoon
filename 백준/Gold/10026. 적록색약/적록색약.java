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

    static int N;
    static char[][] board;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    bfs(new Pair(j,i), board[i][j], 0);
                    count++;
                }
            }
        }

        visited = new boolean[N][N];
        int nCount = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    bfs(new Pair(j,i), board[i][j], 1);
                    nCount++;
                }
            }
        }

        System.out.print(count + " " + nCount);
    }

    public static void bfs(Pair start, char color, int type) {
        Deque<Pair> que = new LinkedList<>();
        que.offer(start);

        while (!que.isEmpty()) {
            Pair now = que.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = now.y + dy[i];
                int nextX = now.x + dx[i];

                if (nextX < 0 || nextY < 0 || nextY >= N || nextX >= N) continue;
                if (visited[nextY][nextX]) continue;
                if(type == 0){
                    if (board[nextY][nextX] != color) continue;
                } else {
                    if((board[nextY][nextX] == 'B' && color == 'G') ||
                            (board[nextY][nextX] == 'G' && color == 'B')||
                            (board[nextY][nextX] == 'B' && color == 'R')||
                            (board[nextY][nextX] == 'R' && color == 'B')) continue;
                }

                visited[nextY][nextX] = true;
                que.offer(new Pair(nextX, nextY));
            }
        }
    }


}
