import java.io.*;
import java.util.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<List<Integer>> inputs  = new ArrayList<>();

        for(int i = 0; i < 3; i ++){

            inputs.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList()));
        }

        for(List<Integer> input : inputs){

            int count = 0;
            for(int item : input){
                if(item == 0) count++;
            }

            System.out.println(answer(count));
        }
    }

    public static String answer(int count){
        if(count == 4){
            return "D";
        } else if(count == 3){
            return "C";
        } else if(count == 2){
            return "B";
        } else if(count == 1){
            return "A";
        } else{
            return "E";
        }
    }
}