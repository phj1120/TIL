package y22.m11.d13;

import java.util.*;
import java.util.stream.Collectors;

public class KNumber {

    public static void main(String[] args) {
        int[] array = new int[5];

        // Array -> List
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());

        // List -> Array
        Integer[] integerList = list.toArray(new Integer[0]);
        Integer[] integerList2 = list.toArray(Integer[]::new);
//        int[] intList = list.toArray(int[]::new); // 기본형 타입 안됨

        int[] intArray = list.stream().mapToInt(Integer::intValue).toArray();

        Solution solution = new Solution();
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] correctAnswer = {5, 6, 3};
        int[] answer = solution.solution(arr, commands);
        System.out.println(Arrays.equals(answer, correctAnswer));
        System.out.println(Arrays.toString(answer));

    }

    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
            List<Integer> answer = new ArrayList<>();
            for (int[] command : commands) {
                int i = command[0];
                int j = command[1];
                int k = command[2];

                List<Integer> subArray = new ArrayList<>(list.subList(i - 1, j));
                Collections.sort(subArray);
                answer.add(subArray.get(k - 1));
            }
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    class Solution2 {
        public int[] solution(int[] array, int[][] commands) {
            List<Integer> answer = new ArrayList<>();
            for (int[] command : commands) {
                int i = command[0];
                int j = command[1];
                int k = command[2];

                int[] subArray = Arrays.copyOfRange(array, i - 1, j);
                Arrays.sort(subArray);
                answer.add(subArray[k - 1]);
            }
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }


}
