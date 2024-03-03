import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = "\\    /\\\n" +
                " )  ( ')\n" +
                "(  /  )\n" +
                " \\(__)|";
        bw.write(s);
        bw.flush();
        bw.close();
    }
}