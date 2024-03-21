import java.io.*;
import java.util.*;
import java.util.stream.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        LinkedList<Integer> dq = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            dq.offerLast(i);
        }

        List<Integer> list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());


        int count = 0;
        for(int item: list){
            int centerIndex;

            if(dq.size() % 2 == 0){
                centerIndex = dq.size() / 2 - 1;
            } else {
                centerIndex = dq.size() / 2;
            }

            if(dq.indexOf(item) <= centerIndex) {
                while (dq.isEmpty() || item != dq.peek()) {
                    dq.addLast(dq.removeFirst());
                    count++;
                }
            } else {
                while (dq.isEmpty() || item != dq.peek()) {
                    dq.addFirst(dq.removeLast());
                    count++;
                }
            }
            dq.removeFirst();
        }

        System.out.print(count);


    }
}