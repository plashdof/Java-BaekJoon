import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> result = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            result.add(x);
        }

        int curItem = 1;
        StringBuilder sb = new StringBuilder();
        for (int item : result) {
            if (item >= curItem) {
                for (int i = curItem; i <= item; i++) {
                    st.push(i);
                    sb.append("+\n");
                }
                curItem = item + 1;
            }

            if(st.peek() != item){
                System.out.print("NO");
                System.exit(0);
            } else {
                st.pop();
                sb.append("-\n");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}