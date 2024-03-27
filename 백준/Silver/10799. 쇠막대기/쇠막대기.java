import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        char lastChar = 'x';
        int count = 0;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < input.length(); i++){
            char item = input.charAt(i);
            if(item == '('){
                st.push('(');
            } else {
                st.pop();
                if(lastChar == '('){
                    // 레이저임
                    count += st.size();
                } else {
                    count += 1;
                }
            }
            lastChar = item;
        }

        System.out.print(count);
    }
}