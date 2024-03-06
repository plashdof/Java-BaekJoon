import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = "*";
        String blank = " ";

        for (int i = 0; i <= N - 2; i++) {
            System.out.print(blank.repeat(N - i - 1));
            System.out.println(str.repeat(1 + 2 * i));
        }

        for (int i = N - 1; i >= 0; i--) {
            System.out.print(blank.repeat(N - i - 1));
            System.out.println(str.repeat(1 + 2 * i));
        }
    }
}
