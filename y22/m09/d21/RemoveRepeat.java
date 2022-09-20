package y22.m09.d21;

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {

        List<Integer> result = new ArrayList<>();
        int prev = -1;
        for (int i : arr) {
            if (prev != i) {
                result.add(i);
            }
            prev = i;
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}

public class RemoveRepeat {

}


