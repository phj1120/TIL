package y22.m11.d23;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SafeShip {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] people = {70, 50, 80, 50};
//        int limit = 100;
//        int correctAnswer = 3;

        int[] people = {70, 80, 50};
        int limit = 100;
        int correctAnswer = 3;

        int answer = solution.solution(people, limit);
        System.out.println(answer == correctAnswer);
        System.out.println(answer);

        List<Integer> list = Arrays.stream(people).boxed().collect(Collectors.toList());
        int[] array = list.stream().mapToInt(Integer::valueOf).toArray();
    }
}

class SolutionFirst {
    public int solution(int[] people, int limit) {
        int count = 0;
        int left = 0, right = people.length - 1;
        Arrays.sort(people);

        while (left <= right) {
            int extraWeight = limit - people[right--];
            while (extraWeight >= people[left]) {
                extraWeight -= people[left];
                left++;
            }
            count++;
        }

        return count;
    }
}


class Solution {
    public int solution(int[] people, int limit) {
        int count = 0;
        int left = 0, right = people.length - 1;
        Arrays.sort(people);

        while (left <= right) {
            if (people[left] + people[right--] <= limit){
                left ++;
            }
            count++;
        }

        return count;
    }
}