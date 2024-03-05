import java.io.*;
import java.util.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<Long> inputs = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong)
                .boxed()
                .collect(Collectors.toList());

        long A = inputs.get(0);
        long B = inputs.get(1);

        if(A < B){
            System.out.println(B - A - 1);

            for (long i = A + 1; i < B; i++) {
                sb.append(i).append(" ");
            }
        } else if(A > B) {
            System.out.println(A - B - 1);

            for (long i = B + 1; i < A; i++) {
                sb.append(i).append(" ");
            }
        } else {
            System.out.println(0);
        }

        if(sb.length() != 0){
            sb.deleteCharAt(sb.length() - 1);
        }

        System.out.print(sb);
    }
}