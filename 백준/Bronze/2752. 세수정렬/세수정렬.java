import java.io.*;
import java.util.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       List<Integer> arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
               .boxed()
               .collect(Collectors.toList());

       Collections.sort(arr);

       StringBuilder sb = new StringBuilder();
       for(int item: arr){
           sb.append(item);
           sb.append(" ");
       }
       sb.deleteCharAt(sb.length() - 1);
       bw.write(String.valueOf(sb));
       bw.flush();
       bw.close();
    }
}