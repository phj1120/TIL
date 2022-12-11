package y22.m12.d11;

import java.util.LinkedList;
import java.util.Queue;

public class Cafe {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] menu;
        int[] order;
        int k;
        int correctAnswer;
        int answer;

        menu = new int[]{5, 12, 30};
        order = new int[]{1, 2, 0, 1};
        k = 10;
        correctAnswer = 3;

        answer = solution.solution(menu, order, k);
        System.out.println(correctAnswer == answer);
        System.out.println(answer);

        menu = new int[]{5};
        order = new int[]{0, 0, 0, 0};
        k = 5;
        correctAnswer = 1;

        answer = solution.solution(menu, order, k);
        System.out.println(correctAnswer == answer);
        System.out.println(answer);
    }
}

class Solution {
    public int solution(int[] menu, int[] order, int k) {
        Queue<Order> orders = new LinkedList<>();
        for (int i = 0; i < order.length; i++) {
            orders.add(new Order(order[i], i * k));
        }

        int customerCountMax = 0, time = 0;
        Queue<Order> cafeInCustomer = new LinkedList<>();
        while (!orders.isEmpty() || !cafeInCustomer.isEmpty()) {
            while (!orders.isEmpty() && orders.peek().requestTime <= time) {
                cafeInCustomer.add(orders.poll());
            }
            if (time % k == 0) {
                customerCountMax = Math.max(customerCountMax, cafeInCustomer.size());
            } else {
                customerCountMax = Math.max(customerCountMax, cafeInCustomer.size() + 1);
            }

            if (cafeInCustomer.isEmpty()) {
                time = getNextK(time, k);
            } else {
                Order now = cafeInCustomer.poll();
                now.setResponseTime(time += menu[now.menu]);
            }
        }

        return customerCountMax;
    }

    private int getNextK(int time, int k) {
        return ((time + k) / k) * k;
    }

    class Order {
        Integer menu;
        Integer requestTime;
        Integer responseTime;

        public Order(Integer menu, Integer requestTime) {
            this.menu = menu;
            this.requestTime = requestTime;
        }

        public void setResponseTime(Integer responseTime) {
            this.responseTime = responseTime;
        }
    }
}
