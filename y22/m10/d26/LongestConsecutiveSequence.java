package y22.m10.d26;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
}

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;

        for (int num : set) {
            // 가장 왼쪽 값이면 탐색 시작
            if (!set.contains(num - 1)) {
                int length = 0;
                while (set.contains(num+length)) {
                    length++;
                }
                longest = Math.max(length, longest);
            }
        }
        return longest;
    }
}

class SecondSolution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;

        for (int num : nums) {
            // 가장 왼쪽 값이면 탐색 시작
            if (!set.contains(num - 1)) {
                int count = 0;
                while (set.contains(num++)) {
                    count++;
                }
                longest = Math.max(count, longest);
            }
        }
        return longest;
    }
}

class FirstSolution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        int longest = 0;

        for (int num:nums){
            // 가장 왼쪽 값이면 탐색 시작
            if (!set.contains(num -1)){
                int count = 0;
                while (true){
                    // 다음 값 존재
                    if(set.contains(num++)){
                        count++;
                    }else{
                        longest = Math.max(count, longest);
                        break;
                    }
                }
            }
        }
        return longest;
    }
}
