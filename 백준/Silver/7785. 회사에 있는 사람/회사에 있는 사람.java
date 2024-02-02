import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Boolean> mp = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String[] strs = br.readLine().split(" ");
            String who = strs[0];
            String type = strs[1];

            if(Objects.equals(type, "enter")){
                mp.put(who, true);
            } else {
                mp.replace(who, false);
            }
        }

        mp.forEach((k,v) -> {
            if(v) result.add(k);
        });

        Collections.sort(result);
        Collections.reverse(result);

        for(String s: result){
            System.out.println(s);
        }
    }
}