package m11.d16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BanUser {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        Solution solution = new SolutionFirst();
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};
        int correctAnswer = 2;
        int answer = solution.solution(user_id, banned_id);

        System.out.println(correctAnswer == answer);
        System.out.println(answer);
    }
}

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        Set<Set<String>> answer = new HashSet<>();
        Map<String, Set<String>> map = new HashMap<>();

        for (String id : banned_id)
            map.put(id, new HashSet<>());

        for (String ban : banned_id) {
            for (String user : user_id) {
                if (!isInclude(user, ban))
                    continue;
                map.get(ban).add(user);
            }
        }
        recursive(new HashSet<>(), -1, null, banned_id, answer, map);
        System.out.println(answer);
        return answer.size();
    }

    public void recursive(Set<String> bannedUser, int index, String user, String[] banned_id,
                          Set<Set<String>> answer, Map<String, Set<String>> map) {
        if (index != -1) {
            bannedUser.add(user);
        }
        index++;

        if (bannedUser.size() == banned_id.length) {
            answer.add(bannedUser);
            return;
        }

        for (String userId : map.get(banned_id[index])) {
            Set<String> nextBannedUser = new HashSet<>(bannedUser);
            if (nextBannedUser.contains(userId))
                continue;
            recursive(nextBannedUser, index, userId, banned_id, answer, map);
        }
    }

    public boolean isInclude(String target, String condition) {
        if (target.length() != condition.length())
            return false;

        for (int i = 0; i < condition.length(); i++) {
            if (condition.charAt(i) == '*')
                continue;
            if (condition.charAt(i) != target.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

class SolutionFirst extends Solution {
    Set<Set<String>> answer = new HashSet<>();
    Map<String, Set<String>> map = new HashMap<>();
    String[] banned_id;

    public int solution(String[] user_id, String[] banned_id) {
        this.banned_id = banned_id;

        for (String id : banned_id)
            map.put(id, new HashSet<>());

        for (String ban : banned_id) {
            for (String user : user_id) {
                if (!isInclude(user, ban))
                    continue;
                map.get(ban).add(user);
            }
        }
        recursive(new HashSet<>(), -1, null);
        return answer.size();
    }

    public void recursive(Set<String> bannedUser, int index, String user) {
        if (index != -1) {
            bannedUser.add(user);
        }
        index++;

        if (bannedUser.size() == banned_id.length) {
            answer.add(bannedUser);
            return;
        }

        for (String userId : map.get(banned_id[index])) {
            Set<String> nextBannedUser = new HashSet<>(bannedUser);
            if (nextBannedUser.contains(userId))
                continue;
            recursive(nextBannedUser, index, userId);
        }
    }

    public boolean isInclude(String target, String condition) {
        if (target.length() != condition.length())
            return false;

        for (int i = 0; i < condition.length(); i++) {
            if (condition.charAt(i) == '*')
                continue;
            if (condition.charAt(i) != target.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
