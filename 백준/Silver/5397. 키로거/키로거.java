import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            List<Character> list = new LinkedList<>();
            ListIterator<Character> it = list.listIterator();
            String inputs = br.readLine();

            for(int j = 0; j < inputs.length(); j++){
                char c = inputs.charAt(j);

                switch(c){
                    case '<':
                        if(it.hasPrevious()){
                            it.previous();
                        }
                        break;
                    case '>':
                        if(it.hasNext()){
                            it.next();
                        }
                        break;
                    case '-':
                        if (it.hasPrevious()) {
                            it.previous();
                            it.remove();
                        }
                        break;
                    default:
                        it.add(c);
                }
            }

            for(char c: list){
                bw.write(c);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        
    }
}