import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> st = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String[] inputs = br.readLine().split(" ");

            switch(inputs[0]){
                case "push":
                    st.push(inputs[1]);
                    break;
                case "top":
                    if(st.isEmpty()){
                        bw.write("-1\n");
                    } else {
                        bw.write(st.peek() + "\n");
                    }
                    break;
                case "size":
                    bw.write(st.size() + "\n");
                    break;
                case "pop":
                    if(st.isEmpty()){
                        bw.write("-1\n");
                    } else {
                        bw.write(st.pop() + "\n");
                    }
                    break;
                case "empty":
                    if(st.isEmpty()){
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                default:
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}