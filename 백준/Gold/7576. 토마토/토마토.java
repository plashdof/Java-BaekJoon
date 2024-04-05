import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static class Pair{
        int x;
        int y;

        Pair(int _x, int _y){
            x = _x;
            y = _y;
        }
    }

    static int N;
    static int M;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Pair> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] mns = br.readLine().split(" ");
        M = Integer.parseInt(mns[0]);
        N = Integer.parseInt(mns[1]);

        board = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){

            List<Integer> inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());

            for(int j = 0; j < M; j++){
                int item = inputs.get(j);
                if(item == 1){
                    list.add(new Pair(j, i));
                }
                board[i][j] = item;
            }
        }

        System.out.print(bfs());
    }
    public static int bfs(){
        Deque<Pair> que = new LinkedList<>();
        for(Pair item: list){
            visited[item.y][item.x] = true;
            que.offer(item);
        }

        while(!que.isEmpty()){
            Pair now = que.poll();

            for(int i = 0; i < 4; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
                if(visited[nextY][nextX] || board[nextY][nextX] == -1) continue;

                visited[nextY][nextX] = true;
                board[nextY][nextX] = board[now.y][now.x] + 1;
                que.offer(new Pair(nextX, nextY));
            }
        }

        int max = -1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] == 0) {
                    return -1;
                }
                if(board[i][j] - 1> max) max = board[i][j] - 1;
            }
        }

        return max;
    }

}