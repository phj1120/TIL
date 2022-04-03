package d220403;

import java.util.Scanner;

public class Q2941 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] cros = {"dz=", "d-", "c=", "c-", "lj", "nj", "s=", "z="};
        for (String cro : cros) {
            while (!(str.indexOf(cro) == -1)) {
                str = str.replace(cro, "*");
            }
        }
        System.out.println(str.length());
    }
}
