import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < k; i++){
            int n = Integer.parseInt(br.readLine());

            if(n == 0){
                st.pop();
            } else {
                st.push(n);
            }
        }

        int sum = 0;
        while(!st.isEmpty()){
            sum += st.pop();
        }

        System.out.print(sum);
    }
}