package y22.m08.d27;

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
