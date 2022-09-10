package y22.m09.d10;

import java.util.Scanner;

public class Q2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        for(int index = 1 ; index < arr.length ; index++){
            int temp = arr[index];
            int aux = index - 1;

            while( (aux >= 0) && ( arr[aux] > temp ) ) {
                arr[aux + 1] = arr[aux];
                aux--;
            }
            arr[aux + 1] = temp;
        }


        for (int i : arr) {
            System.out.println(i);
        }
    }
}

/*
5
5
2
3
4
1
 */
