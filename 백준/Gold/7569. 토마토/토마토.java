import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {


    public static class Pair{
        int x;
        int y;
        int z;

        Pair(int _x, int _y, int _z){
            x = _x;
            y = _y;
            z = _z;
        }
    }
    static int M;
    static int N;
    static int H;

    static int[][][] board;
    static boolean[][][] visited;

    static int[] dx = {0, 0, 0, 0, 1, -1};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {1, -1, 0, 0, 0, 0};

    static List<Pair> starts = new ArrayList<>();

    static int day = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        M = Integer.parseInt(inputs[0]);
        N = Integer.parseInt(inputs[1]);
        H = Integer.parseInt(inputs[2]);

        board = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                List<Integer> list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toList());

                for (int k = 0; k < M; k++) {
                    board[i][j][k] = list.get(k);
                    if(list.get(k) == 1){
                        starts.add(new Pair(k,j,i));
                    }
                }
            }
        }

        bfs();

        int max = -1;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(board[i][j][k] == 0){
                        System.out.print(-1);
                        System.exit(0);
                    } else if(board[i][j][k] > max){
                        max = board[i][j][k];
                    }
                }
            }
        }

        System.out.print(max - 1);
    }

    public static void bfs(){

        Deque<Pair> que = new LinkedList<>();
        for(Pair item : starts){
            que.offer(item);
            visited[item.z][item.y][item.x] = true;
        }

        while(!que.isEmpty()){

            Pair now = que.poll();

            for(int i = 0; i < 6; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                int nextZ = now.z + dz[i];

                if(nextX < 0 || nextY < 0 || nextZ < 0 || nextX >= M || nextY >= N || nextZ >= H) continue;
                if(visited[nextZ][nextY][nextX] || board[nextZ][nextY][nextX] == -1 || board[nextZ][nextY][nextX] == 1) continue;

                visited[nextZ][nextY][nextX] = true;
                board[nextZ][nextY][nextX] = board[now.z][now.y][now.x] + 1;
                que.offer(new Pair(nextX, nextY, nextZ));
            }
        }

    }
}