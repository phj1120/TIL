package y22.m11.d03;

import java.util.*;

public class Budget {
    static class Solution {
        public int solution(int[] d, int budget) {
            Arrays.sort(d);
            int sum = 0, count = 0;
            for (int i = 0; i < d.length; i++) {
                sum += d[i];
                if (sum > budget) break;
                count++;
            }

            return count;
        }
    }
}

