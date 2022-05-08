// 78.1 / 100
// 시간 초과 남
// 인정 비효율적이긴 한듯

package y22.m05.d08;


import java.util.ArrayList;
import java.util.HashMap;

public class answer2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(sol.solution(record));
    }
}

class Solution {
    static HashMap<String, String> users = new HashMap<>();
    static ArrayList<HashMap<String, String>> logs = new ArrayList<>();

    public static String printMsg(String id, String type) {
        String nickname = users.get(id);
        if ("Leave".equals(type)) {
            return nickname + "님이 나갔습니다.";
        } else {
            return nickname + "님이 들어왔습니다.";
        }
    }

    public String[] solution(String[] record) {
        for (String rec : record) {
            String[] command = rec.split(" ");
            String actType = command[0];
            String userId = command[1];
            if ("Leave".equals(actType)) {
                logs.add(newLog(actType, userId));
                continue;
            }

            String userNickname = command[2];
            if ("Enter".equals(actType)) {
                String nickname = users.get(userId);
                System.out.println("users = " + users);
                System.out.println("nickname = " + nickname);
                System.out.println("userNickname = " + userNickname);
                if (nickname==null) {
                    users.put(userId, userNickname);
                } else if (!userNickname.equals(nickname)) {
                    users.replace(userId, userNickname);
                }
                logs.add(newLog(actType, userId));
                continue;
            }
            if ("Change".equals(actType)) {
                users.replace(userId, userNickname);
            }
        }
        System.out.println(users);
        System.out.println(logs);

        String[] answer = new String[logs.size()];

        for (int i = 0; i < logs.size(); i++) {
            String id = logs.get(i).get("id");
            String type = logs.get(i).get("type");
            answer[i] = printMsg(id, type);
        }

        return answer;
    }

    private HashMap<String, String> newLog(String actType, String userId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("type", actType);
        map.put("id", userId);
        return map;
    }
}