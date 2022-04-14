package y22.m04.d14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StrResortSol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
//        String str = "K1KA5CB7";
        int value = 0;

        ArrayList<Character> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                result.add(str.charAt(i));
            }else{
                value += str.charAt(i) - '0';
            }
        }

        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
        }
        if(value!=0) System.out.print(value);
        System.out.println();
    }
}