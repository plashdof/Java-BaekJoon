import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        Stack<Character> leftStack = new Stack<Character>();
        Stack<Character> rightStack = new Stack<Character>();

        for(int i = 0; i < s.length(); i++){
            leftStack.push(s.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String[] inputs = br.readLine().split(" ");
            String keyword = inputs[0];
            if(Objects.equals(keyword, "L")){
                if(!leftStack.isEmpty()){
                    rightStack.push(leftStack.pop());
                }

            } else if(Objects.equals(keyword, "D")){
                if(!rightStack.isEmpty()){
                    leftStack.push(rightStack.pop());
                }

            } else if(Objects.equals(keyword, "B")){
                if(!leftStack.isEmpty()){
                    leftStack.pop();
                }
            } else if(Objects.equals(keyword, "P")){
                leftStack.push((inputs[1].charAt(0)));
            } else {

            }
        }

        while(!leftStack.isEmpty()){
            rightStack.push(leftStack.pop());
        }

        while(!rightStack.isEmpty()){
            bw.write(rightStack.pop());
        }

        bw.flush();
        bw.close();


    }
}