import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = "*";
        String blank = " ";

        for(int i = 0; i <= N - 1; i++){
            System.out.print(blank.repeat(N-i-1));
            System.out.println(str.repeat(1 + 2 * i));
        }
    }
}