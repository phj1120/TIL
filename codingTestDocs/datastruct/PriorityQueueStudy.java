package y22.m11.d11;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringJoiner;

public class PriorityQueueStudy {
    public static void main(String[] args) {
        System.out.println("우선 순위 큐는 힙 자료 구조를 이용해 추가와 삽입 시 일정 우선 순위를 가지고으로 크기를 비교해, \n" +
                "그 우선 순위에 맞게 꺼낼 수 있는 큐다." +
                "전체의 순위가 보장 되는 것이 아니라, 우선 순위가 가장 높은 것이 보장 됨.\n" +
                "print 문으로 찍어봐도 큰 의미 없음");
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>();

        integerPriorityQueue.add(1);
        integerPriorityQueue.add(2);
        integerPriorityQueue.add(4);
        integerPriorityQueue.add(3);
        integerPriorityQueue.add(5);
        System.out.println(integerPriorityQueue);

        System.out.println(integerPriorityQueue.poll());
        System.out.println(integerPriorityQueue.poll());
        System.out.println(integerPriorityQueue.poll());
        System.out.println(integerPriorityQueue.poll());
        System.out.println(integerPriorityQueue.poll());

        System.out.println("---------------");


        System.out.println("객체를 이용해 우선 순위 큐를 만들 수 있는데,\n" +
                "해당 객체가 Comparable 인터페이스를 구현 해야한다. ");
        PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<>();
        nodePriorityQueue.add(new Node(2));
        nodePriorityQueue.add(new Node(4));
        nodePriorityQueue.add(new Node(1));
        nodePriorityQueue.add(new Node(3));
        nodePriorityQueue.add(new Node(5));
        System.out.println(nodePriorityQueue);

        System.out.println(nodePriorityQueue.poll());
        System.out.println(nodePriorityQueue.poll());
        System.out.println(nodePriorityQueue.poll());
        System.out.println(nodePriorityQueue.poll());
        System.out.println(nodePriorityQueue.poll());

        System.out.println("---------------");

        System.out.println("remove 를 이용해 중간 값을 삭제 할 수도 있는데,\n" +
                "순서에 맞게 제대로 정렬 되고, \n" +
                "객체의 경우 equals 와 hashCode 를 오버라이딩 해줘야한다.\n");
        nodePriorityQueue.add(new Node(2));
        nodePriorityQueue.add(new Node(4));
        nodePriorityQueue.add(new Node(1));
        nodePriorityQueue.add(new Node(3));
        nodePriorityQueue.add(new Node(5));
        System.out.println(nodePriorityQueue);

        nodePriorityQueue.remove(new Node(3));
        System.out.println(nodePriorityQueue.poll());
        System.out.println(nodePriorityQueue.poll());
        System.out.println(nodePriorityQueue.poll());
        System.out.println(nodePriorityQueue.poll());

        System.out.println("우선순위 큐 안에 들어간 상태로 값이 바뀌면?\n" +
                "내부 값이 실시간으로 다시 정렬 되는 것이 아니다.\n" +
                "추가, 삭제 시 조건에 맞게 저장 되는 것. \n" +
                "-> 우선 순위 큐에 넣고 값 바꾸지 말 것.");
        /**
         추가
         마지막 위치에 추가 -> 부모 노드와 비교 반복
         비교 기준은 어떻게 정하느냐에 따라 다름
         루트 노드 까지 비교

         삭제
         추가 연산 반대로.
         루트 노드를 삭제하고 마지막에 있는 노드를 루트로 가지고와 자식 노드와 바꿈
         두 자식 노드 중 더 작은 것과 비교해 교환 함

         https://st-lab.tistory.com/205
         */
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        nodePriorityQueue.add(node1);
        nodePriorityQueue.add(node2);
        nodePriorityQueue.add(node3);
        nodePriorityQueue.add(node4);
        nodePriorityQueue.add(node5);
        System.out.println("기존 : "+nodePriorityQueue);

        node5.setX(1);
        node4.setX(2);
        node3.setX(3);
        node2.setX(4);
        node1.setX(5);

        System.out.println("수정 : "+nodePriorityQueue);
        nodePriorityQueue.add(new Node(6));
        nodePriorityQueue.add(new Node(7));

        System.out.println(nodePriorityQueue.poll());
        System.out.println(nodePriorityQueue.poll());
        System.out.println(nodePriorityQueue.poll());
        System.out.println(nodePriorityQueue.poll());
        System.out.println(nodePriorityQueue.poll());
        System.out.println(nodePriorityQueue.poll());
        System.out.println(nodePriorityQueue.poll());




    }

    static class Node implements Comparable {
        int x;

        public Node(int x) {
            this.x = x;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        @Override
        public int compareTo(Object o) {
            Node node = (Node) o;
//            return node.getX() - this.getX();
            return this.getX() - node.getX();
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                    .add("x=" + x)
                    .toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x);
        }
    }
}
