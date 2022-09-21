package y22.m09.d22;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

class FirstSolution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();

        int max = Integer.MIN_VALUE;
        for (String operation : operations) {
            if (operation.equals("D 1") && !priorityQueue.isEmpty()) {
                priorityQueue.remove(max);
                if (priorityQueue.isEmpty()) {
                    max = Integer.MIN_VALUE;
                } else {
                    max = priorityQueue.stream().max((i1, i2) -> {
                        return i1 - i2;
                    }).get();
                }
            } else if (operation.equals("D -1") && !priorityQueue.isEmpty()) {
                priorityQueue.poll();
                if (priorityQueue.isEmpty()) {
                    max = Integer.MIN_VALUE;
                } else {
                    max = priorityQueue.stream().max((i1, i2) -> {
                        return i1 - i2;
                    }).get();
                }
            } else {
                String[] data = operation.split(" ");
                if (data[0].equals("I")) {
                    int number = Integer.parseInt(data[1]);
                    priorityQueue.add(number);
                    if (max < number) {
                        max = number;
                    }
                }
            }
        }

        int[] answer = new int[2];
        if (!priorityQueue.isEmpty()) {
            answer[1] = priorityQueue.peek();
            answer[0] = max;
        }
        return answer;
    }
}

class SecondSolution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();

        Integer max = null;
        for (String operation : operations) {
            if (operation.equals("D 1") && !priorityQueue.isEmpty()) {
                priorityQueue.remove(max);
                if (priorityQueue.isEmpty()) {
                    max = null;
                } else {
                    max = priorityQueue.stream().max((i1, i2) -> {
                        return i1 - i2;
                    }).get();
                }
            } else if (operation.equals("D -1") && !priorityQueue.isEmpty()) {
                priorityQueue.poll();
                if (priorityQueue.isEmpty()) {
                    max = null;
                } else {
                    max = priorityQueue.stream().max((i1, i2) -> {
                        return i1 - i2;
                    }).get();
                }
            } else {
                String[] data = operation.split(" ");
                if (data[0].equals("I")) {
                    int number = Integer.parseInt(data[1]);
                    priorityQueue.add(number);
                    if (max == null || max < number) {
                        max = number;
                    }
                }
            }
        }

        int[] answer = new int[2];
        if (!priorityQueue.isEmpty()) {
            answer[1] = priorityQueue.peek();
            answer[0] = max;
        }
        return answer;
    }
}

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();

        Integer max = null;
        for (String operation : operations) {
            if (operation.equals("D 1") && !priorityQueue.isEmpty()) {
                priorityQueue.remove(max);
                max = getMax(priorityQueue);
            } else if (operation.equals("D -1") && !priorityQueue.isEmpty()) {
                priorityQueue.poll();
                max = getMax(priorityQueue);
            } else {
                String[] data = operation.split(" ");
                if (data[0].equals("I")) {
                    int number = Integer.parseInt(data[1]);
                    priorityQueue.add(number);
                    if (max == null || max < number) {
                        max = number;
                    }
                }
            }
        }

        int[] answer = new int[2];
        if (!priorityQueue.isEmpty()) {
            answer[1] = priorityQueue.peek();
            answer[0] = max;
        }
        return answer;
    }

    private Integer getMax(PriorityQueue<Integer> priorityQueue) {
        Integer max = null;
        if (!priorityQueue.isEmpty()) {
            max = priorityQueue.stream()
                    .mapToInt(v -> v)
                    .max()
                    .orElseThrow(NoSuchElementException::new);
        }
        return max;
    }
}

public class DoublePriorityQueue {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
//        int[] correctResult = {333, -45};
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int[] correctResult = {0, 0};
        int[] answer = solution.solution(operations);
        System.out.println(Arrays.equals(correctResult, answer));
        System.out.println(Arrays.toString(answer));
    }

}
