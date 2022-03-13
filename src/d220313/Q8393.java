package d220313;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q8393 {
    public static void main(String args[]) throws Exception{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();

        int num = Integer.parseInt(str);
        int sum = 0;

        for(int i = 1; i<=num; i++){
            sum += i;
        }
        System.out.print(sum);
    }
}
