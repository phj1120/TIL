package y22.m08.d22;

import java.util.ArrayList;
import java.util.List;

public class NewId {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String answer1 = solution.solution("...!@BaT#*..y.abcdefghijklm");
        String result1 = "bat.y.abcdefghi";
        System.out.println(answer1.equals(result1));
        String answer2 = solution.solution("=.=");
        String result2 = "aaa";
        System.out.println(answer2.equals(result2));
    }
}

class Solution {
    public String solution(String new_id) {
        String answer = "";
        // 1
        new_id = new_id.toLowerCase();

        // 2
        answer = new_id.replaceAll("[^a-z0-9-_.]", "");

        // 3
        answer = answer.replaceAll("\\.+", ".");

        // 4
        answer = answer.replaceAll("^[.]|[.]$", "");

        // 5
        if (answer.isEmpty()) {
            answer = "a";
        }

        // 6
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }

        // 7
        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }
}

class Solution1 {
    public String solution(String new_id) {
        String answer = "";
        // 1
        new_id = new_id.toLowerCase();

        // 2
        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if (Character.isAlphabetic(ch) || Character.isDigit(ch) ||
                    ch == '.' || ch == '_' || ch == '-') {
                answer += ch;
            }
        }

        // 3
        while (answer.indexOf("..") != -1) {
            answer = answer.replace("..", ".");
        }

        // 4
        if (!answer.isEmpty() && answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }
        if (!answer.isEmpty() && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }

        // 5
        if (answer.isEmpty()) {
            answer = "a";
        }

        // 6
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            if (answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, 14);
            }
        }

        // 7
        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }
}

class FailSolution {
    public String solution(String new_id) {
        String answer = "";
//        1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();

//        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        char[] idArray = new_id.toCharArray();
        List<Character> idList = new ArrayList<>();
        for (int i = 0; i < idArray.length; i++) {
            char ch = idArray[i];
            if (Character.isAlphabetic(ch) || ch == '-' || ch == '_' || ch == '.') {
                idList.add(ch);
            }
        }

//        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        for (int i = 0; i < idList.size() - 1; i++) {
            if (idList.get(i) == '.' && idList.get(i + 1) == '.') {
                idList.remove(i);
                i -= 1;
            }
        }

//        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        while (true) {
            int lastIndex = idList.size() - 1;
            if (idList.get(0) != '.' && idList.get(lastIndex) != '.') {
                break;
            }
            if (idList.get(lastIndex) == '.') {
                idList.remove(lastIndex);
            }
            if (idList.get(0) == '.') {
                idList.remove(0);
            }
        }

//        5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (idList.isEmpty()) {
            idList.add('a');
        }
//        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//                만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if (idList.size() >= 16) {
            idList = idList.subList(0, 15);
        }
        while (true) {
            int lastIndex = idList.size() - 1;
            if (idList.get(lastIndex) != '.') {
                break;
            }
            if (idList.get(lastIndex) == '.') {
                idList.remove(lastIndex);
            }
        }

//        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        while (idList.size() < 3) {
            idList.add(idList.get(idList.size() - 1));
        }

        for (char ch : idList) {
            answer += ch;
        }
        return answer;
    }
}
