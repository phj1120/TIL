package d220324;

import java.lang.management.MemoryType;
import java.util.Scanner;

public class AntWarrior {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] f = new int[cnt];
        int[] fMax = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            f[i] = sc.nextInt();
        }

        fMax[0] = f[0];
        fMax[1] = f[1];
        fMax[2] = f[0] + f[2];
        for (int i = 3; i < cnt; i++) {
            fMax[i] = Math.max(fMax[i - 3], fMax[i - 2]) + f[i];
        }

        System.out.println(Math.max(fMax[cnt - 1], fMax[cnt - 2]));

    }
}
