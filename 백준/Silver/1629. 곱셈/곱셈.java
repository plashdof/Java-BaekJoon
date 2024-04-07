import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {


    // 모듈러 합동공식을 알고 있어야 풀수 있는 문제
    // (a * b) % c = (a % c) * (b % c) % c

    // 지수법칙도 알아야함
    // a^(n+m) = a^n * a^m
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        long A = Long.parseLong(inputs[0]);
        long B = Long.parseLong(inputs[1]);
        C = Integer.parseInt(inputs[2]);

        System.out.println(pow(A, B));

    }

    public static long pow(long value, long e){
        if(e == 1) return value % C;

        long temp = pow(value, e / 2);

        // 현재 지수가 홀 수 였다면
        // A^(e / 2) * A^(e / 2) * A 이므로
        // A를 한 번 더 곱해주어야 한다.
        //
        // ex) A^9 = A^4 * A^4 * A
        if(e % 2 == 1) return (temp * temp % C) * value % C;

        // 그 외에는 짝수이므로 구했던 값을 한 번 더 곱해서 반환한다
        return temp * temp % C;
    }
}