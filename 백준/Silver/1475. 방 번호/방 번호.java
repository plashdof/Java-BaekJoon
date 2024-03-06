import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];

        String s = br.readLine();

        for(int i = 0; i < s.length(); i++){
            int idx = Integer.parseInt(s.substring(i, i+1));

            if(idx == 6 || idx == 9){
                if(arr[6] > arr[9]){
                    arr[9] += 1;
                } else {
                    arr[6] += 1;
                }
            } else {
                arr[idx] += 1;
            }
        }

        int max = -1;
        for(int item: arr){
            if(max < item) max = item;
        }

        System.out.print(max);
    }
}