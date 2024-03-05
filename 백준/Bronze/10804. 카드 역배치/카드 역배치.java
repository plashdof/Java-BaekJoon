import java.io.*;
import java.util.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] deck = new int[21];

        for (int i = 1; i < 21; i++) {
            deck[i] = i;
        }

        for (int i = 0; i < 10; i++) {
            String[] strs = br.readLine().split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            swap(deck, a, b);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < 21; i++){
            sb.append(deck[i]).append(" ");
        }

        sb.deleteCharAt(sb.length() -1);
        System.out.print(sb);
    }

    static void swap(int[] deck, int a, int b) {
        Stack<Integer> temp = new Stack<>();

        int n = b - a + 1;

        for (int i = a; i <= b; i++) {
            temp.push(deck[i]);
        }

        for (int i = 0; i < n; i++) {
            deck[a + i] = temp.pop();
        }
    }
}