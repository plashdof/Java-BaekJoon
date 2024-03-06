import java.io.*;
import java.util.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = "*";
        String blank = " ";
        for(int i = N; i >= 1; i--){
            System.out.println(str.repeat(i));
        }

    }
}