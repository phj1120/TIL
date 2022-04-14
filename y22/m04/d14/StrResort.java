package y22.m04.d14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class StrResort {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
        String str = "K1KA5CB7";
        String totalStr = "";
        int totalInt = 0;
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (ch >= 'A' && ch <= 'Z') {
                totalStr += ch;
            }
            if (ch >= '0' && ch <= '9') {
                totalInt += ch - '0';
            }
        }

        char[] sortChars = totalStr.toCharArray();
        Arrays.sort(sortChars);
        String sortStr = "";
        for (char sortChar : sortChars) {
            sortStr += sortChar;
        }
        System.out.print(sortStr+totalInt);
    }
}
