// 78.1 / 100
// 시간 초과 남
// 인정 비효율적이긴 한듯

package y22.m05.d06;

import java.util.ArrayList;

public class answer1{
    public static void main(String[] args) {
        System.out.println("args = " + args);
    }    
}

class Solution {
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<logMap> logs = new ArrayList<>();

    public static User getUser(String id) {
        for (User user: users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public static String printMsg(String id, String type){
        User user = getUser(id);
        String nickname = user.getNickname();
        if("Leave".equals(type)){
            return nickname+"님이 나갔습니다.";
        }else{
            return nickname+"님이 들어왔습니다.";
        }
    }

    public String[] solution(String[] record) {
        for(String rec:record){
            String[] command = rec.split(" ");
            String actType = command[0];
            String userId = command[1];
            if ("Leave".equals(actType)){
                logs.add(new logMap(userId, actType));
                continue;
            }

            String userNickname = command[2];
            if ("Enter".equals(actType)){
                User user = getUser(userId);
                if (user == null){
                    users.add(new User(userId, userNickname));
                }else if (!user.getNickname().equals(userNickname)){
                    user.setNickname(userNickname);
                }
                logs.add(new logMap(userId, actType));
                continue;
            }
            if ("Change".equals(actType)){
                User user = getUser(userId);
                user.setNickname(userNickname);
            }
        }
        // System.out.println(users);
        // System.out.println(logs);

        String[] answer = new String[logs.size()];

        for(int i = 0; i<logs.size(); i++){
            String id = logs.get(i).getId();
            String type = logs.get(i).getType();
            answer[i] = printMsg(id, type);
        }

        return answer;
    }
}

class logMap{
    String id;
    String type;

    public logMap(String id, String type){
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


}

class User {
    String id;
    String nickname;

    public User(String id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
}