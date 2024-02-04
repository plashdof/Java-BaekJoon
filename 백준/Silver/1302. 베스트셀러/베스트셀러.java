import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> mp = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            if(mp.containsKey(s)){
                mp.replace(s, mp.get(s) + 1);
            } else {
                mp.put(s, 1);
            }
        }

        final int[] max = {-1};

        mp.forEach((k,v) -> {
            if(v > max[0]) max[0] = v;
        });

        ArrayList<String> arr = new ArrayList<>();

        mp.forEach((k,v) -> {
           if(v == max[0]) arr.add(k);
        });

        Collections.sort(arr);
        System.out.print(arr.get(0));

    }
}