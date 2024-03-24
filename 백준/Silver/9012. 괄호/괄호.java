import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n; i++){
            String input = br.readLine();
            Stack<Character> st = new Stack<>();

            boolean isBalanced = true;
            loop : for(int j = 0; j < input.length(); j++){
                switch(input.charAt(j)){
                    case '(':
                        st.push('(');
                        break;
                    case ')':
                        if(st.isEmpty()){
                            isBalanced = false;
                            break loop;
                        } else {
                            if(st.peek() == '('){
                                st.pop();
                            } else {
                                isBalanced = false;
                                break loop;
                            }
                        }
                        break;
                    default:
                        break;
                }
            }

            if(isBalanced){
                if(st.isEmpty()){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }
    }
}