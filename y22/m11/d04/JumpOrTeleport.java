package y22.m11.d04;

public class JumpOrTeleport {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(5);
        System.out.println(solution1);
    }

    static class Solution {
        public int solution(int n) {
            int fuel = 0;
            while (n != 0) {
                if (n % 2 != 0) {
                    fuel++;
                }
                n /= 2;
            }
            return fuel;
        }
    }
}

