import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");

        int N = Integer.parseInt(strs[0]);
        int K = Integer.parseInt(strs[1]);

        List<Integer> list = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            list.add(i);
        }

        ListIterator<Integer> it = list.listIterator();

        int temp = 0;
        while(true){
            for(int i = 0; i < K; i++){
                if (!it.hasNext()) {
                    it = list.listIterator();
                }
                temp = it.next();
            }

            if(list.size() == 1){
                result.add(list.get(0));
                list.remove(0);
            } else {
                it.remove();
                result.add(temp);
            }

            if(list.isEmpty()) break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int item: result){
            sb.append(item).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(">");
        System.out.print(sb);
    }
}