import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            Deque<String> dq = new ArrayDeque<>();
            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            sb.append(br.readLine());
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length() - 1);
            String input = sb.toString();

            String[] strs = input.split(",");

            for(String item: strs){
                if(!item.isBlank()){
                    dq.offer(item);
                }
            }

            boolean isReversed = false;
            boolean isError = false;
            loop : for(int j = 0; j < cmd.length(); j++){
                if(cmd.charAt(j) == 'R'){
                    isReversed = !isReversed;
                } else {
                    if (dq.isEmpty()) {
                        isError = true;
                        break loop;
                    } else {
                        if(isReversed){
                            dq.removeLast();
                        } else {
                            dq.removeFirst();
                        }
                    }
                }
            }

            StringBuilder output = new StringBuilder();
            if(isError){
                bw.write("error");
                bw.newLine();
            } else if(dq.isEmpty()){
                bw.write("[]");
                bw.newLine();
            } else {
                output.append("[");
                if(isReversed){
                    while(!dq.isEmpty()){
                        output.append(dq.removeLast()).append(",");
                    }
                } else {
                    while(!dq.isEmpty()){
                        output.append(dq.removeFirst()).append(",");
                    }
                }

                output.deleteCharAt(output.length() - 1);
                output.append("]");
                bw.write(output.toString());
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }
}
