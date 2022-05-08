package y22.m05.d08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Sol {
    public static void main(String[] args) {
        BestSolution best = new BestSolution();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] correctResult = {"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};
        String[] result = best.solution(record);

        if (Arrays.equals(result, correctResult)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}

class BestSolution {
    private static final String ENTER_FORMAT = "%s님이 들어왔습니다.";
    private static final String LEAVE_FORMAT = "%s님이 나갔습니다.";

    private HashMap<String, UserInfo> userMap = new HashMap<>();

    private class UserInfo {
        public String userId;
        public String nickName;

        public UserInfo(String userId, String nickName) {
            this.userId = userId;
            this.nickName = nickName;
        }

    }

    private class Command {
        public char command;
        public String userId;

        public Command(char command, String userName) {
            this.command = command;
            this.userId = userName;
        }
    }


    public String[] solution(String[] records) {
        ArrayList<Command> commandList = new ArrayList<>();

        for (String record : records) {
            String[] split = record.split(" ");
            String command = split[0];
            String userId = split[1];
            String nickName = null;

            switch(command.charAt(0)) {
                case 'E': // Enter
                    nickName = split[2];
                    if(userMap.containsKey(userId) == false) {
                        userMap.put(userId, new UserInfo(userId, nickName));
                    } else {
                        userMap.get(userId).nickName = nickName;
                    }

                    commandList.add(new Command(command.charAt(0), userId));
                    break;
                case 'L': // Leave
                    commandList.add(new Command(command.charAt(0), userId));
                    break;
                case 'C': // Change
                    nickName = split[2];
                    userMap.get(userId).nickName = nickName;
                    break;
            }
        }

        return commandList.stream()
                .map(cmd -> String.format( cmd.command == 'E' ? ENTER_FORMAT : LEAVE_FORMAT , userMap.get(cmd.userId).nickName))
                .toArray(ary -> new String[commandList.size()]);
    }
}
