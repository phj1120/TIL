package y22.m05.d06;

import java.util.ArrayList;
import java.util.HashMap;

public class prac {
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<HashMap<String, User>> userMap = new ArrayList<>();


    public static User getUser(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public String[] solution(String[] record) {
        User user1 = new User("park1", "haru1");
        User user2 = new User("park2", "haru2");
        User user3 = new User("park3", "haru3");

        for (String rec : record) {

        }
        System.out.println(" d d ".split(" "));
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.size();


        System.out.println(users);
        String[] strArr = {};
        System.out.println(getUser("park1").getNickname());


        String[] answer = {};
        return answer;
    }
}
