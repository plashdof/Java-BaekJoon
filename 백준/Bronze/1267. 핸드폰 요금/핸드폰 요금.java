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

        int Y = 0;
        int M = 0;

        for (int i = 0; i < N; i++) {
            Y += 10 + (inputs.get(i) / 30) * 10;
            M += 15 + (inputs.get(i) / 60) * 15;
        }

        if (Y > M) {
            System.out.print("M " + M);
        } else if (Y < M) {
            System.out.print("Y " + Y);
        } else {
            System.out.print("Y M " + M);
        }
    }
}