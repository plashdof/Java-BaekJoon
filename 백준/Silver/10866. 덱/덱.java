import java.io.*;
import java.util.*;
import java.util.stream.*;


public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<String> dq = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            String[] strs = br.readLine().split(" ");

            switch(strs[0]){
                case "push_back":
                    dq.addLast(strs[1]);
                    break;
                case "push_front":
                    dq.addFirst(strs[1]);
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
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(dq.peekLast()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "pop_front":
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.remove()).append("\n");
                    }
                    break;
                case "pop_back":
                    if (dq.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.removeLast()).append("\n");
                    }
                    break;
                case "empty":
                    if(dq.isEmpty()){
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                default:
                    break;
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}