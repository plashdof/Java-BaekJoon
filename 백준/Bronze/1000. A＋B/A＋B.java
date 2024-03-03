import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int num1 = Integer.parseInt(strs[0]);
        int num2 = Integer.parseInt(strs[1]);

        System.out.print(num1 + num2);
    }
}
