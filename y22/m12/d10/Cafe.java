package y22.m12.d10;

import java.util.LinkedList;
import java.util.Queue;

public class Cafe {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] menu = {5, 12, 30};
        int[] order = {1, 2, 0, 1};
        int k = 10;
        int correctAnswer = 3;
        int answer = solution.solution(menu, order, k);
        System.out.println(correctAnswer == answer);
        System.out.println(answer);
    }
}

class Solution {
    public int solution(int[] menu, int[] order, int k) {
        Queue<Order> orders = new LinkedList<>();
        for (int data : order) {
            orders.add(new Order(data));
        }

        int time = 0;
        Queue<Order> incomingOrders = new LinkedList<>();
        Order processOrder = orders.poll();
        incomingOrders.add(processOrder);
        int customerCount = 0;
        while (!orders.isEmpty() && !incomingOrders.isEmpty()) {
            // 현재 제작 중인 음료가 없고,
            if (processOrder == null) {
                // 제작해야 하는 음료가 없는 경우 다음 10초로 이동
                if (incomingOrders.isEmpty()) {
                    time = getNextTen(time);
                    incomingOrders.add(processOrder);
                } else {
                    // 제작해야 하는 음료가 있는 경우 음료 제작 시작
                    processOrder = incomingOrders.poll();
                    processOrder.setReceiveTime(time + menu[processOrder.menu]);
                    customerCount++;
                }
                continue;
            }

            // 제작 중인 음료가 있는 경우
            int nextTen = getNextTen(time);
            int nextReceiveTime = processOrder.receiveTime;
            // 음료가 제작되는 시간이 다음 10초일 경우
            if (nextReceiveTime == nextTen) {
                processOrder = incomingOrders.poll();
            }

            // 다음 10초가 빠른 경우


            // 음료 제작 종료가 더 빠른 경우
            time = Math.min(getNextTen(time), processOrder.receiveTime);

            //
            if (time == 10) {

            }


        }

        return customerCount;
    }

    private int getNextTen(int time) {
        return ((time + 10) / 10) * 10;
    }

    class Order {
        Integer menu;
        Integer receiveTime;

        public Order(Integer menu) {
            this.menu = menu;
        }

        public void setReceiveTime(Integer receiveTime) {
            this.receiveTime = receiveTime;
        }
    }
}
