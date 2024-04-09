import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        String num = br.readLine();

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            if (st.isEmpty()) {
                st.push(c);
            } else {
                if (M == 0) {
                    st.push(c);
                } else {
                    while(!st.isEmpty()){
                        if(M == 0){
                            st.push(c);
                            break;
                        }

                        if (st.peek() < c) {
                            st.pop();
                            M--;
                        } else {
                            st.push(c);
                            break;
                        }

                        if(st.isEmpty()){
                            st.push(c);
                            break;
                        }
                    }
                }
            }
        }

        if(M > 0){
            while(M > 0){
                st.pop();
                M--;
            }
        }

        Stack<Character> print = new Stack<>();
        while (!st.isEmpty()) {
            print.push(st.pop());
        }

        while (!print.isEmpty()) {
            System.out.print(print.pop());
        }
    }
}