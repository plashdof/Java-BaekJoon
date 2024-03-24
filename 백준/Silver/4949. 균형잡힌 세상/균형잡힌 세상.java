import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while(true){
            input = br.readLine();

            if(Objects.equals(input, ".")){
                break;
            }
            Stack<Character> st = new Stack<>();
            boolean isBalance = true;

            loop : for(int i = 0; i < input.length() - 1; i++){
                char item = input.charAt(i);

                switch(item){
                    case '(':
                        st.push(item);
                        break;
                    case '[':
                        st.push(item);
                        break;
                    case ')':
                        if(st.isEmpty()){
                            isBalance = false;
                            break loop;
                        } else {
                            if(st.peek() == '('){
                                st.pop();
                            } else {
                                isBalance = false;
                                break loop;
                            }
                        }
                        break;
                    case ']':
                        if(st.isEmpty()){
                            isBalance = false;
                            break loop;
                        } else {
                            if(st.peek() == '['){
                                st.pop();
                            } else {
                                isBalance = false;
                                break loop;
                            }
                        }
                        break;
                    default:
                        break;
                }
            }

            if(isBalance){
                if(st.isEmpty()){
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            } else {
                System.out.println("no");
            }
        }
    }
}