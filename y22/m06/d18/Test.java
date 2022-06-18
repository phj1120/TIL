package y22.m06.d18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        String[] participant = {"leo", "kiki", "eden", "leo"};
        String[] completion = {"leo", "kiki", "eden", "leo"};
        String answer = "";
        List<String> completionList = new ArrayList<>();
        completionList.addAll(Arrays.asList(completion));
        int leo = completionList.indexOf("leo");

        for (String participantName : participant) {
            for (String completionName : completion) {
                if (completionName.equals(participantName)) {
                    int i = completionList.indexOf(completionName);
                    if (i == -1) {
//                        return completionList.get(i);
                    }
//                    completionList.remove(i);
                    break;
                }
            }
        }

        answer = completionList.get(0);
    }

}
