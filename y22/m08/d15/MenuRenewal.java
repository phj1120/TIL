package y22.m08.d15;

import java.util.*;

public class MenuRenewal {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        String[] result = {"AC", "ACDE", "BCFG", "CDE"};

        String[] answer = solution.solution(orders, course);

        if (Arrays.equals(answer, result)) {
            System.out.println("정답 입니다.");
        } else {
            System.out.println("오답 입니다.");

            System.out.println("RESULT");
            for (String s : answer) {
                System.out.print(s + " ");
            }
            System.out.println();
            System.out.println("ANSWER");
            for (String s : result) {
                System.out.print(s + " ");
            }

        }

    }
}

class Solution {
    List<String> answerList = new ArrayList<>();
    Map<String, Integer> hashMap = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {

        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        for (int courseLength : course) {
            for (String order : orders) {
                combination("", order, courseLength);
            }

            if (!hashMap.isEmpty()) { // 조합이 만들어졌다면.
                ArrayList<Integer> countList = new ArrayList<>(hashMap.values());
                int max = Collections.max(countList);

                if (max > 1) {
                    for (String key : hashMap.keySet()) {
                        if (hashMap.get(key) == max) {
                            answerList.add(key);
                        }
                    }
                }
                hashMap.clear();
            }
        }
        Collections.sort(answerList);

        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    private void combination(String order, String others, int count) {
        // 탈출 조건
        if (count == 0) {
            hashMap.put(order, hashMap.getOrDefault(order, 0) + 1);
            return;
        }

        // 수행 동작
        for (int i = 0; i < others.length(); i++) {
            combination(order + others.charAt(i), others.substring(i + 1), count - 1);
        }
    }
}
