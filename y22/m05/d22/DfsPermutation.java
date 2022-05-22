package y22.m05.d22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DfsPermutation {
    static int arr[];
    static int ans[];
    static int check[];
    static int n;
    static int m;

    static ArrayList<ArrayList<Integer>>arraylist;

    void dfs(int l) {
        if (l==m) {
            // 출력
            ArrayList<Integer>templist= new ArrayList<>();
            for (int i=0;i<m;i++) {
                templist.add(ans[i]);
            }
            arraylist.add(templist);
        }
        else{
            for (int i=0;i<n;i++) {
                if (check[i]==0) {
                    check[i]=1;
                    ans[l]=arr[i];
                    dfs(l+1);
                    check[i]=0; // 다 사용했으면 다시 풀어줌.
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        n=scan.nextInt();
        m=scan.nextInt();

        arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=scan.nextInt();
        }

        ans=new int[m];
        check=new int[n];
        arraylist=new ArrayList<>();

        DfsPermutation dfsPermutation = new DfsPermutation();
        dfsPermutation.dfs(0);

        // 정답 출력하는 arraylist

        for (int i=0;i< arraylist.size();i++) {
            System.out.println(arraylist.get(i));
        }
    }
}