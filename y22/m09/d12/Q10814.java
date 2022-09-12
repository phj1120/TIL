package y22.m09.d12;

import java.util.Arrays;
import java.util.Scanner;

// 325444KB	3024ms
public class Q10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] infos = new String[n];
        for (int i = 0; i < n; i++) {
            infos[i] = sc.nextLine();
        }
        sc.close();

        Arrays.sort(infos, (s1, s2) -> {
            int s1Age = Integer.parseInt(s1.split(" ")[0]);
            int s2Age = Integer.parseInt(s2.split(" ")[0]);
            return s1Age - s2Age;
        });

        for (String info : infos) {
            System.out.println(info);
        }
    }
}

//213152KB	2328ms
class Q10814_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Member[] members = new Member[n];
        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split(" ");
            int age = Integer.parseInt(data[0]);
            String name = data[1];
            members[i] = new Member(age, name);
        }
        sc.close();

        Arrays.sort(members, (m1, m2)->{
            return m1.age - m2.age;
        });

        for (Member member : members) {
            System.out.println(member.age + " " + member.name);
        }
    }
}

class Member {
    int age;
    String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }
}