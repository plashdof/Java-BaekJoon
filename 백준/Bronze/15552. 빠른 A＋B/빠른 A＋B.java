import java.io.*;
import java.util.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i < T; i++){
            String[] strs = br.readLine().split(" ");
            int A = Integer.parseInt(strs[0]);
            int B = Integer.parseInt(strs[1]);

            arr.add(A+B);
        }

        for(int i = 0; i < T; i++){
            bw.write(arr.get(i).toString() + "\n");
        }

        bw.flush();
        bw.close();
    }
}