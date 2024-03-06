import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1000001];

        List<Integer> inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Collections.sort(inputs);

        for (int item : inputs) {
            arr[item] += 1;
        }

        int x = Integer.parseInt(br.readLine());

        int count = 0;
        for (int item : inputs) {
            if (x > item && x - item <= 1000000 && x - item != item && arr[x - item] == 1) {
                count += 1;
                arr[item] = 0;
            }
        }

        System.out.print(count);

    }
}