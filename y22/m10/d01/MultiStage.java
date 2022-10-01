package y22.m10.d01;

import java.util.*;

class Solution {
    static class People {
        private String name;
        private People inviter;
        private List<People> invitee = new ArrayList<>();
        private int sales = 0;

        public People(String name) {
            this.name = name;
        }

        public void addSales(int sales) {
            this.sales += sales;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setInviter(People inviter) {
            this.inviter = inviter;
        }

        public String getName() {
            return name;
        }

        public People getInviter() {
            return inviter;
        }

        public List<People> getInvitee() {
            return invitee;
        }

        public int getSales() {
            return sales;
        }
    }

    void calculate(People people, int sales) {
        if (people == null)
            return;


        if ((int) Math.floor(sales * 0.1) < 1) {
            people.addSales(sales);
            return;
        }

        people.addSales(sales - (int) Math.floor(sales * 0.1));
        People inviter = people.getInviter();
        calculate(inviter, (int) Math.floor(sales * 0.1));
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, People> peoples = new HashMap<>();
        for (String name : enroll)
            peoples.put(name, new People(name));

        for (int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            String inviterName = referral[i];
            if (!inviterName.equals("-")) {
                People people = peoples.get(name);
                People inviter = peoples.get(inviterName);
                people.setInviter(inviter);
                inviter.getInvitee().add(people);
            }
        }

        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int sales = amount[i] * 100;
            People people = peoples.get(name);
            calculate(people, sales);
        }

        int[] answer = new int[enroll.length];
        for (
                int i = 0;
                i < enroll.length; i++) {
            answer[i] = peoples.get(enroll[i]).getSales();
        }

        return answer;
    }
}

public class MultiStage {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        int[] correctAnswer = {360, 958, 108, 0, 450, 18, 180, 1080};

        int[] answer = solution.solution(enroll, referral, seller, amount);
        System.out.println(Arrays.equals(correctAnswer, answer));
        System.out.println(Arrays.toString(answer));
    }

}
