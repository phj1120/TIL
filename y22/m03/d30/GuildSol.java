package y22.m03.d30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GuildSol {

    public static int n;
    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arrayList.add(sc.nextInt());
        }
        Collections.sort(arrayList);

        int result = 0, count = 0;
        for (int i = 0; i < n; i++) {
            count += 1;
            if (arrayList.get(i) <= count) {
                result += 1;
                count = 0;
            }
        }
        System.out.print(result);
    }
}
