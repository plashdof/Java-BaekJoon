import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<int[]> mpList = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String[] strs = br.readLine().split(" ");
            int s = Integer.parseInt(strs[0]);
            int e = Integer.parseInt(strs[1]);
            int[] intList = {s, e};
            mpList.add(intList);
        }

        // 끝나는 타임 기준 오름차순 정렬
        mpList.sort((a,b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int count = 0;
        int lastTime = 0;
        for ( int[] intList: mpList ){
            if(lastTime <= intList[0]){
                lastTime = intList[1];
                count++;
            }
        }

        System.out.println(count);
    }
}