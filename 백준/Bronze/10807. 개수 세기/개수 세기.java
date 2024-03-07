import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine());

       List<Integer> inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
               .boxed()
               .collect(Collectors.toList());

       int v = Integer.parseInt(br.readLine());

       int count = 0;
       for(int item: inputs){
           if(item == v){
               count++;
           }
       }

       System.out.print(count);

    }
}