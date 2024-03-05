import java.io.*;
import java.util.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int min = 101;
        int sum = 0;

        for(int i = 0; i < 7; i++){
            int n = Integer.parseInt(br.readLine());
            if(n % 2 != 0){
                sum += n;
                if(min > n) min = n;
            }
        }

        if(sum == 0){
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.print(min);
        }

    }

}