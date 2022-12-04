package y22.m12.d04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AloneAlphabet {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String inputString = "edeaaabbccd";
        String correctAnswer = "de";
        String answer = solution.solution(inputString);
        System.out.println(correctAnswer.equals(answer));
        System.out.println(answer);
    }

}

class Solution {
    public String solution(String input_string) {
        Set<Character> existAlphabet = new HashSet<>();
        Set<Character> aloneAlphabet = new HashSet<>();

        existAlphabet.add(input_string.charAt(0));
        for (int i = 1; i < input_string.length(); i++) {
            char now = input_string.charAt(i);

            // 이미 외톨이 알파벳이면 다음 문자열 탐색
            if (aloneAlphabet.contains(now)) {
                continue;
            }

            char prev = input_string.charAt(i - 1);
            // 이미 존재하는 값인데, 연속 되지 않는 경우 외톨이 알파벳임
            if (existAlphabet.contains(now) && prev != now) {
                aloneAlphabet.add(now);
            }

            // 현재 나온 알파벳 추가
            existAlphabet.add(now);
        }

        ArrayList<Character> list = new ArrayList<>(aloneAlphabet);
        if (list.isEmpty()) {
            return "N";
        }

        Collections.sort(list);
        String answer = "";
        for (Character character : list) {
            answer += character;
        }
        return answer;
    }
}
