import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        // K개의 원판을 1에서 3으로 이동시키는데 2가 경유지일경우
        move(K, 1, 2, 3);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(count);
        System.out.print(sb);
    }

    public static void move(int cnt, int s, int m, int e) {

        if(cnt == 0) return;

        // start 에서 mid 로 이동하는데 end를 거친다
        move(cnt - 1, s, e, m);
        sb.append(s).append(" ").append(e).append("\n");
        count++;
        
        // mid 에서 end 로 이동하는데 start를 거친다
        move(cnt - 1, m, s, e);
    }
}