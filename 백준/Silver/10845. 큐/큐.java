import java.io.*;
import java.util.*;
import java.util.stream.*;



public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> que = new LinkedList<>();

        int back = -1;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            String[] strs = br.readLine().split(" ");
            switch(strs[0]){
                case "push":
                    back = Integer.parseInt(strs[1]);
                    que.offer(back);
                    break;
                case "front":
                    if(que.peek() != null){
                        sb.append(que.peek()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "back":
                    if(que.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(back).append("\n");
                    }
                    break;
                case "size":
                    sb.append(que.size()).append("\n");
                    break;
                case "empty":
                    if(que.isEmpty()){
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "pop":
                    if (que.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(que.remove()).append("\n");
                    }
                    break;
                default:
                    break;
            }
        }
        if(sb.length() != 0){
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.print(sb);

    }
}