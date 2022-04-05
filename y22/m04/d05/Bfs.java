package y22.m04.d05;

import java.util.*;

public class Bfs {
    static ArrayList<ArrayList<Integer>> g;
    static ArrayList<Boolean> isCheck;
    static String result;

    public static void main(String[] args) {
        init();
        Queue<Integer> q = new LinkedList();

        q.offer(1);
        while (!q.isEmpty()) {
            int p = q.poll();
            System.out.println("g.get(p) = " + g.get(p));
            for (int i = 0; i < g.get(p).size(); i++) {

                if (!isCheck.get(g.get(p).get(i))) {
                    System.out.println("i : " +i);
                    System.out.println("g.get(p).get(i) = " + g.get(p).get(i));
                    int y = g.get(p).get(i);
                    q.offer(y);
                    System.out.println(q);
                    isCheck.set(i, true);
                    result += y + " ";
                }
            }
        }
        System.out.println(result);
    }

    static public void init() {
        g = new ArrayList<ArrayList<Integer>>();
        isCheck = new ArrayList<Boolean>();
        result = "";

        // 그래프 초기화
        for (int i = 0; i < 9; i++) {
            isCheck.add(false);
            g.add(new ArrayList<Integer>());
        }
        isCheck.add(false);

        // 노드 1에 연결된 노드 정보 저장
        g.get(1).add(2);
        g.get(1).add(3);
        g.get(1).add(8);

        // 노드 2에 연결된 노드 정보 저장
        g.get(2).add(1);
        g.get(2).add(7);

        // 노드 3에 연결된 노드 정보 저장
        g.get(3).add(1);
        g.get(3).add(4);
        g.get(3).add(5);

        // 노드 4에 연결된 노드 정보 저장
        g.get(4).add(3);
        g.get(4).add(5);

        // 노드 5에 연결된 노드 정보 저장
        g.get(5).add(3);
        g.get(5).add(4);

        // 노드 6에 연결된 노드 정보 저장
        g.get(6).add(7);

        // 노드 7에 연결된 노드 정보 저장
        g.get(7).add(2);
        g.get(7).add(6);
        g.get(7).add(8);

        // 노드 8에 연결된 노드 정보 저장
        g.get(8).add(1);
        g.get(8).add(7);
    }
}
