package m12.d23;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CarFleet {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int target = 12;
//        int[] position = {10, 8, 0, 5, 3};
//        int[] speed = {2, 4, 1, 1, 3};
//        int correctAnswer = 3;

        int target = 10;
        int[] position = {3};
        int[] speed = {3};
        int correctAnswer = 1;

//        int target = 100;
//        int[] position = {0, 2, 4};
//        int[] speed = {4, 2, 1};
//        int correctAnswer = 1;

        int answer = solution.carFleet(target, position, speed);
        System.out.println(answer == correctAnswer);
        System.out.println(answer);
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Car> fleet = new Stack<>();
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++)
            cars.add(new Car(position[i], speed[i]));

        for (int i = position.length - 1; i >= 0; i--) {
            Car car = cars.get(i);
            if (!fleet.isEmpty() && calculateGoalTime(target, fleet.peek()) >= calculateGoalTime(target, car)) {
                continue;
            }
            fleet.push(car);
        }

        return fleet.size();
    }

    public int calculateGoalTime(int distance, Car car) {
        return (distance - car.position) / car.speed;
    }

    class Car implements Comparable<Car> {
        int position;
        int speed;

        public Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }

        @Override
        public int compareTo(Car o) {
            return o.position - this.position;
        }
    }
}