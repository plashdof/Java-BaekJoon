import java.io.*;
import java.util.*;
import java.util.stream.*;

class Top{
    int index;
    int height;

    Top(int index, int height){
        this.index = index;
        this.height = height;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        List<Top> tops = new ArrayList<>();

        int index = 1;
        for(int item: list){
            tops.add(new Top(index, item));
            index++;
        }

        Stack<Top> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(Top item: tops){
            if(st.isEmpty()){
                sb.append(0).append(" ");
            } else {
                while(!st.isEmpty() && st.peek().height < item.height){
                    st.pop();
                }

                if(st.isEmpty()){
                    sb.append(0).append(" ");
                } else {
                    sb.append(st.peek().index).append(" ");
                }
            }

            st.push(item);
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);

    }
}