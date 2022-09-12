package y22.m09.d13;

import java.util.*;

public class Phonecketmon {
    public int solution(int[] nums) {
        int answer = 0;

        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        return Math.min(nums.length / 2, set.size());
    }
}
