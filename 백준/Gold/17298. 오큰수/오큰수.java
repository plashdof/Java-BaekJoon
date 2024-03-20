import java.io.*;
import java.util.*;
import java.util.stream.*;



public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] result = new int[1000001];

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Stack<Integer> st = new Stack<>();
        for(int i = list.size() - 1; i >= 0; i--){
            if(st.isEmpty()){
                result[i+1] = -1;
            } else {
                while(!st.isEmpty() && st.peek() <= list.get(i)){
                    st.pop();
                }
                if(st.isEmpty()){
                    result[i+1] = -1;
                } else {
                    result[i+1] = st.peek();
                }
            }
            st.push(list.get(i));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            sb.append(result[i]).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}