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
    static int r;
    static int c;

    static int[] dx = {0, 1, 0, 1};
    static int[] dy = {0, 0, 1, 1};

    // (c,r)

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        r = Integer.parseInt(inputs[1]);
        c = Integer.parseInt(inputs[2]);
        recursion(0, 0, (int) Math.pow(2, N));
        System.out.print(count);
    }

    public static void recursion(int x, int y, int size) {

        if (size == 1) {
            return;
        }


        if (c - x >= size / 2 && r - y >= size / 2) {
            // 4사분면
            count += (size * size / 4) * 3;
            recursion(x + size / 2, y + size / 2, size / 2);
        } else if (c - x >= size / 2 && r - y < size / 2) {
            // 2사분면
            count += (size * size / 4);
            recursion(x + size / 2, y, size / 2);
        } else if (c - x < size / 2 && r - y >= size / 2) {
            // 3사분면
            count += (size * size / 4) * 2;
            recursion(x, y + size / 2, size / 2);
        } else {
            // 1사분면
            recursion(x, y, size / 2);
        }

    }
}