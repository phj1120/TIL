package y22.m04.d05;

import java.util.ArrayList;
import java.util.Stack;
// 1 2 7 6 8 3 4 5

public class Dfs {
    static ArrayList<ArrayList<Integer>> g;
    static ArrayList<Boolean> isCheck;
    static Stack<Integer> s;
    static String result;
    void dfsStack(int start) {
        int p;
        s.push(start);
        while (!s.isEmpty()) {
            p = s.pop();
            if (!isCheck.get(p)) { // 현재 위치가 체크 된 적이 없으면 // 트리가 아니라 그래프.
                result += p + " ";
                isCheck.set(p, true);
                for (int i = g.get(p).size() - 1; i >=0 ; i--) {
                    int y = g.get(p).get(i);
                    if (!isCheck.get(y)) {
                        s.push(y);
                    }
                }
            }
        }
    }

    void dfsRecursive(int p) {
        isCheck.set(p, true);
        result += p + " ";
        for (int i = 0; i <g.get(p).size(); i++) {
            int y = g.get(p).get(i);
            if (!isCheck.get(y)) {
                dfsRecursive(y);
            }
        }
    }

    public void init() {
        g = new ArrayList<ArrayList<Integer>>();
        isCheck = new ArrayList<Boolean>();
        s = new Stack<Integer>();
        result = "";

        // 그래프 초기화
        for (int i = 0; i < 9; i++) {
            isCheck.add(false);
            g.add(new ArrayList<Integer>());
        }

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
