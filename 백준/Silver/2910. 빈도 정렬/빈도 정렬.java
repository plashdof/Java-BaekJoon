import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> mp = new LinkedHashMap<>();
        String[] strs;

         strs = br.readLine().split(" ");
         int n = Integer.parseInt(strs[0]);
         int c = Integer.parseInt(strs[1]);

        strs = br.readLine().split(" ");

        for(String s: strs){
            if(mp.containsKey(s)){
                mp.replace(s,mp.get(s) + 1);
            } else {
                mp.put(s,1);
            }
        }

        List<Map.Entry<String, Integer>> mpList = new ArrayList<>(mp.entrySet());
        mpList.sort((ent1, ent2) -> ent2.getValue().compareTo(ent1.getValue()));

        for ( Map.Entry<String, Integer> entry: mpList ){
            System.out.print((entry.getKey() + " ").repeat(entry.getValue()));
        }

    }
}