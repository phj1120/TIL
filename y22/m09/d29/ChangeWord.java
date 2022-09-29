package y22.m09.d29;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static class Word {
        String name;
        int depth;

        public Word(String name, int depth) {
            this.name = name;
            this.depth = depth;
        }
    }

    public int solution(String begin, String target, String[] words) {
        Queue<Word> queue = new LinkedList<>();
//        List<String> list = Arrays.asList(words); // asList 로 생성한 리스트는 변경 불가
        List<String> list = Arrays.stream(words).collect(Collectors.toList());

        if (list.stream().filter(s -> {
            return s.equals(target);
        }).findFirst() == null) {
            return 0;
        }

        queue.add(new Word(begin, 0));

        int depth = 0;
        while (!queue.isEmpty()) {
            Word now = queue.poll();
            String nowName = now.name;
            int nowDepth = now.depth;

            if (target.equals(now.name)) {
                depth = now.depth;
                break;
            }

            List<String> changeableList = new ArrayList<>();
            for (String str : list) {
                if (isChangeable(nowName, str)) {
                    changeableList.add(str);
                }
            }

            for (String str : changeableList) {
                queue.add(new Word(str, nowDepth + 1));
                list.remove(str);
            }
        }

        return depth;
    }

    public boolean isChangeable(String begin, String target) {
        boolean state = false;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i)) {
                if (state) {
                    return false;
                }
                state = true;
            }
        }
        return state;
    }
}

public class ChangeWord {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        int correctAnswer = 4;
        int answer = solution.solution(begin, target, words);

        System.out.println(correctAnswer == answer);
        System.out.println(answer);
    }
}
