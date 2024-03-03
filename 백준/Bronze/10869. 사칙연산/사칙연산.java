import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        int A = arr.get(0);
        int B = arr.get(1);

        bw.write((A+B) + "\n" + (A-B) + "\n" + (A*B) + "\n" + (A/B) + "\n" + (A%B));
        bw.flush();
        bw.close();
    }
}