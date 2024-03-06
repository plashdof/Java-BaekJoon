import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];

        int result = 1;
        for(int i = 0; i < 3; i++){
            result = result * Integer.parseInt(br.readLine());
        }

        String s = String.valueOf(result);

        for(int i = 0; i < s.length(); i++){
            arr[Integer.parseInt(String.valueOf(s.charAt(i)))] += 1;
        }

        for(int item : arr){
            System.out.println(item);
        }
    }
}