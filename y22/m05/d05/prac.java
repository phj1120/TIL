package y22.m05.d05;

import java.util.ArrayList;

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

public class prac {
    static ArrayList<User> users = new ArrayList<>();

    public static User getUser(String id) {
        for (User user: users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        User user1 = new User("park1", "haru1");
        User user2 = new User("park2", "haru2");
        User user3 = new User("park3", "haru3");

        users.add(user1);
        users.add(user2);
        users.add(user3);

        System.out.println(users);

        System.out.println(getUser("park1").getNickname());
    }


}
