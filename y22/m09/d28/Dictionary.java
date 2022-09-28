package y22.m09.d28;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    ArrayList<String> list = new ArrayList<>();
    String[] vowels = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        recursive("");
        Collections.sort(list);
        return list.indexOf(word) + 1;
    }


    public void recursive(String word) {
        if (word.length() > 4) {
            return;
        }
        for (String vowel : vowels) {
            recursive(word + vowel);
            list.add(word+vowel);
        }
    }
}


public class Dictionary {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String word = "AAAAE";
        int answer = solution.solution(word);
        int correctAnswer = 6;
        System.out.println(answer == correctAnswer);
        System.out.println(answer);
    }
}

