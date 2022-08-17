package y22.m08.d17;

import java.util.*;

public class NotCompletionPlayer {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        String result = "leo";

        String answer = sol.solution(participant, completion);
        System.out.println("Objects.equals(result, answer) = " + Objects.equals(result, answer));
    }

}

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> participantMap = new HashMap<>();
        Map<String, Integer> completionMap = new HashMap<>();

        for (String name : participant) {
            participantMap.put(name, participantMap.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            completionMap.put(name, completionMap.getOrDefault(name, 0) + 1);
        }

        for (String name : participantMap.keySet()) {
            if (!participantMap.get(name).equals(completionMap.get(name))) {
                answer = name;
                break;
            }
        }
        return answer;
    }
}

class LectureSolution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        for (String player : completion) {
            map.put(player, map.get(player) - 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}

class LectureSolution2 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        for (String player : completion) {
            map.put(player, map.get(player) - 1);
        }

        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }
}