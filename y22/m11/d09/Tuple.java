package y22.m11.d09;

import java.util.*;

public class Tuple {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
    }

    static class Solution {
        public int[] solution(String s) {
            // string -> tuple 로 변환
            String[] splits = s.replace("{{", "").replace("}}", "").split("\\},\\{");
            List<Set<Integer>> list = new ArrayList<>();
            for (String split : splits) {
                Set<Integer> tuple = new HashSet<>();
                String[] nums = split.split(",");
                for (String num : nums) {
                    tuple.add(Integer.parseInt(num.trim()));
                }
                list.add(tuple);
            }

            // 길이로 정렬
            Collections.sort(list, (s1, s2) -> s1.size() - s2.size());

            // n 번째 tuple 에서 새로 나온 숫자가 전체 tuple 의 n 번째 원소
            int[] answer = new int[list.size()];
            Set<Integer> dictionary = new HashSet<>(); // list 보다 set 의 contains 시간 복잡도가 적으므로.
            for (int i = 0; i < answer.length; i++) {
                Set<Integer> sets = list.get(i);
                for (Integer num : sets) {
                    if (!dictionary.contains(num)) {
                        dictionary.add(num);
                        answer[i] = num;
                        break;
                    }
                }
            }
            return answer;
        }
    }

    static class SolutionFirst {
        public int[] solution(String s) {
            s = s.replace("{{", "").replace("}}", "");
            String[] split = s.split("\\},\\{");
            List<Set<Integer>> list = new ArrayList<>();
            for (String str : split) {
                Set<Integer> set = new HashSet<>();
                String[] nums = str.split(",");
                for (String num : nums) {
                    set.add(Integer.parseInt(num.trim()));
                }
                list.add(set);
            }
            Collections.sort(list, (set1, set2) -> {
                return set1.size() - set2.size();
            });

            int[] answer = new int[list.size()];
            Set<Integer> dictionary = new HashSet<>();
            for (int i = 0; i < answer.length; i++) {
                Set<Integer> sets = list.get(i);
                for (Integer num : sets) {
                    if (!dictionary.contains(num)) {
                        dictionary.add(num);
                        answer[i] = num;
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
