import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 0; i < n; i++){
            String input = br.readLine();
            Stack<Character> st = new Stack<>();

            for(int j = 0; j < input.length(); j++){
                if(st.isEmpty()){
                    st.push(input.charAt(j));
                } else {
                    if(st.peek() == input.charAt(j)){
                        st.pop();
                    } else {
                        st.push(input.charAt(j));
                    }
                }
            }

            if(st.isEmpty()){
                count++;
            }
        }

        System.out.print(count);

    }
}