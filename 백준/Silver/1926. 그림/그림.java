import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static class Pair {
        int x;
        int y;

        Pair(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }

        int grimCount = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    // bfs 시작. 그림 count+
                    grimCount++;
                    Pair temp = new Pair(j,i);
                    int width = bfs(temp, board);
                    if( max < width ){
                        max = width;
                    };
                }
            }
        }

        System.out.println(grimCount);
        System.out.println(max);
    }

    static int bfs(Pair start, int[][] board) {
        Queue<Pair> que = new LinkedList<Pair>();

        que.offer(start);
        board[start.y][start.x] = 0;
        int width = 1;

        while (!que.isEmpty()) {
            Pair node = que.poll();

            if (node.x > 0) {
                if (board[node.y][node.x - 1] == 1) {
                    board[node.y][node.x - 1] = 0;
                    Pair temp = new Pair(node.x - 1, node.y);
                    que.offer(temp);
                    width++;
                }
            }

            if (node.y > 0) {
                if (board[node.y - 1][node.x] == 1) {
                    board[node.y - 1][node.x] = 0;
                    Pair temp = new Pair(node.x, node.y - 1);
                    que.offer(temp);
                    width++;
                }
            }

            if (node.x < m - 1) {
                if (board[node.y][node.x + 1] == 1) {
                    board[node.y][node.x + 1] = 0;
                    Pair temp = new Pair(node.x + 1, node.y);
                    que.offer(temp);
                    width++;
                }
            }

            if (node.y < n - 1) {
                if (board[node.y + 1][node.x] == 1) {
                    board[node.y + 1][node.x] = 0;
                    Pair temp = new Pair(node.x, node.y + 1);
                    que.offer(temp);
                    width++;
                }
            }
        }

        return width;
    }
}