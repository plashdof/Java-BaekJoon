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

    static boolean[][] visited;
    static int[][] board;

    static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};

    static int I;
    static int endX;
    static int endY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());

            visited = new boolean[I][I];
            board = new int[I][I];

            String[] starts = br.readLine().split(" ");
            int startY = Integer.parseInt(starts[0]);
            int startX = Integer.parseInt(starts[1]);

            String[] ends = br.readLine().split(" ");
            endY = Integer.parseInt(ends[0]);
            endX = Integer.parseInt(ends[1]);

            bw.write(bfs(new Pair(startX, startY)));
        }

        bw.flush();
        bw.close();
    }

    public static String bfs(Pair start){
        Deque<Pair> que = new LinkedList<>();
        visited[start.y][start.x] = true;
        que.offer(start);

        while(!que.isEmpty()){

            Pair now = que.poll();

            for(int i = 0; i < 8; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= I || nextY >= I) continue;
                if(visited[nextY][nextX]) continue;

                visited[nextY][nextX] = true;
                board[nextY][nextX] = board[now.y][now.x] + 1;

                if(nextY == endY && nextX == endX){
                    return String.valueOf(board[nextY][nextX] + "\n");
                }

                que.offer(new Pair(nextX, nextY));
            }
        }

        return String.valueOf(board[endY][endX] + "\n");
    }
}