import java.io.*;
import java.util.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toList());

        int a = arr.get(0);
        int b = arr.get(1);
        int c = arr.get(2);

        if(a == b && b == c){
            System.out.print(10000 + a * 1000);
        } else if(a == b || a == c){
            System.out.print(1000 + a * 100);
        } else if(b == c){
            System.out.print(1000 + b * 100);
        } else {
            Collections.sort(arr);
            System.out.print(arr.get(2) * 100);
        }

    }
}