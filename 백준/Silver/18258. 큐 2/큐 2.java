import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> dq = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            String[] inputs = br.readLine().split(" ");

            switch(inputs[0]){
                case "push":
                    dq.offer(Integer.parseInt(inputs[1]));
                    break;
                case "front":
                    if(dq.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.peek()).append("\n");
                    }
                    break;
                case "back":
                    if(dq.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.peekLast()).append("\n");
                    }
                    break;
                case "pop":
                    if(dq.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.remove()).append("\n");
                    }
                    break;
                case "empty":
                    if(dq.isEmpty()){
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                default:
                    break;
            }
        }

        System.out.print(sb);

    }
}