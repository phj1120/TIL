package y22.m08.d27;

import java.util.HashSet;
import java.util.Set;

public class ReserveClothes {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.print(sol.solution(5, lost, reserve));
    }
}

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for (int student : lost) {
            lostSet.add(student);
        }
        for (int student : reserve) {
            reserveSet.add(student);
        }

        for (int student : reserveSet) {
            // 본인
            if (lostSet.contains(student)) {
                lostSet.remove(student);
            }
            // 좌측
            else if (!reserveSet.contains(student - 1) && lostSet.contains(student - 1)) {
                lostSet.remove(student - 1);
            }

            // 우측
            else if (!reserveSet.contains(student + 1) && lostSet.contains(student + 1)) {
                lostSet.remove(student + 1);
            }
        }
        System.out.println(lostSet);
        System.out.println(reserveSet);

        return n - lostSet.size();
    }
}

class BestSolution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 1. Set을 만든다
        HashSet<Integer> resList = new HashSet<>();
        HashSet<Integer> losList = new HashSet<>();

        for (int i : reserve)
            resList.add(i);
        for (int i : lost) {
            if (resList.contains(i))
                resList.remove(i);
            else
                losList.add(i);
        }

        // 2. 여분을 기준으로 앞뒤를 확인하여 체육복을 빌려준다.
        for (int i : resList) {
            if (losList.contains(i - 1))
                losList.remove(i - 1);
            else if (losList.contains(i + 1))
                losList.remove(i + 1);
        }
        // 3. 최대한 나눠준 뒤에 lost에 남아있는 학생들은 체육복이 없는 학생들이다.
        return n - losList.size();
    }
}