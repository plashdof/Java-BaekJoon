import java.io.*;
import java.util.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(br.readLine());

        if((year % 4 == 0 && year % 100 != 0 )|| year % 400 == 0){
            System.out.print("1");
        } else {
            System.out.print("0");
        }

    }
}