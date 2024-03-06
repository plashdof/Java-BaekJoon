import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alphabets = new int[27];

        String s = br.readLine();

        for(int i = 0; i < s.length(); i++){
            alphabets[s.charAt(i) - 'a'] += 1;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 26; i++){
            sb.append(alphabets[i]).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        System.out.print(sb);
    }
}