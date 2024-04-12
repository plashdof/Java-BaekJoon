import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static char[][] board;
    static List<Character> list = new ArrayList<>();
    static int[] dx = {0,1,0,1};
    static int[] dy = {0,0,1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        board = new char[N][N];

        for(int i = 0; i < N; i++){
            String input = br.readLine();

            for(int j = 0; j < N; j++){
                board[i][j] = input.charAt(j);
            }
        }
        recursion(0,0,N);

        for(char item : list){
            System.out.print(item);
        }

    }

    public static void recursion(int x, int y, int size){

        if(size == 1){
            list.add(board[y][x]);
            return;
        }

        char temp = board[y][x];
        boolean flag = false;
        loop : for(int i = y; i < y + size; i++){
            for(int j = x; j < x + size; j++){
                if(temp != board[i][j]){
                   flag = true;
                   break loop;
                }
            }
        }

        if(flag){
            list.add('(');
            for(int i = 0; i < 4; i++){
                recursion(x + dx[i] * size / 2, y + dy[i] * size / 2, size / 2);
            }
            list.add(')');
        } else {
            list.add(temp);
        }
    }
}