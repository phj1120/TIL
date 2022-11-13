package datastruct;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringJoiner;

public class PriorityQueueStudy {
    PriorityQueue<Node> priorityQueue;

    @BeforeEach
    public void setUp() {
        priorityQueue = new PriorityQueue<>();
    }

    /**
     * 우선 순위 큐는 힙 자료 구조를 이용해 추가와 삽입 시 일정 우선 순위를 가지고으로 크기를 비교해,
     * 그 우선 순위에 맞게 꺼낼 수 있는 큐다.
     * 전체의 순위가 보장 되는 것이 아니라, 우선 순위가 가장 높은 것이 보장 됨.
     * print 문으로 찍어봐도 큰 의미 없음
     */
    @Test
    @DisplayName("정의")
    public void 정의() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(4);
        priorityQueue.add(3);
        priorityQueue.add(5);
        System.out.println(priorityQueue);

        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }

    /**
     * 객체를 이용해 우선 순위 큐를 만들 수 있는데,
     * 해당 객체가 Comparable 인터페이스를 구현 해야한다.
     */
    @Test
    @DisplayName("클래스를 만들어 사용하고 싶을 경우 Comparable 구현")
    public void 클래스를_만들어_사용하고_싶을_경우() {
        priorityQueue.add(new Node(2));
        priorityQueue.add(new Node(4));
        priorityQueue.add(new Node(1));
        priorityQueue.add(new Node(3));
        priorityQueue.add(new Node(5));
        System.out.println(priorityQueue);

        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }

    /**
     * remove 를 이용해 중간 값을 삭제 할 수도 있는데,
     * 순서에 맞게 제대로 정렬 되고,
     * 객체의 경우 equals 와 hashCode 를 오버라이딩 해줘야한다.
     */
    @Test
    public void 중간값_삭제_해도_정상_처리_됨() {
        priorityQueue.add(new Node(2));
        priorityQueue.add(new Node(4));
        priorityQueue.add(new Node(1));
        priorityQueue.add(new Node(3));
        priorityQueue.add(new Node(5));
        System.out.println(priorityQueue);

        priorityQueue.remove(new Node(3));
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }

    /**
     * 우선순위 큐 안에 들어간 상태로 값이 바뀌면?
     * 내부 값이 실시간으로 다시 정렬 되는 것이 아니다.
     * 추가, 삭제 시 조건에 맞게 저장 되는 것.
     * -> 우선 순위 큐에 넣고 값 바꾸지 말 것
     */
    @Test
    @DisplayName("삽입 한 값 변경하지 말기")
    public void 삽입_된_채_값이_바뀔경우_유지_되지_않음() {
        System.out.println(".");
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        priorityQueue.add(node1);
        priorityQueue.add(node2);
        priorityQueue.add(node3);
        priorityQueue.add(node4);
        priorityQueue.add(node5);
        System.out.println("기존 : " + priorityQueue);

        node5.setX(1);
        node4.setX(2);
        node3.setX(3);
        node2.setX(4);
        node1.setX(5);

        System.out.println("수정 : " + priorityQueue);
        priorityQueue.add(new

                Node(6));
        priorityQueue.add(new

                Node(7));

        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }

    /**
     * 추가
     * 마지막 위치에 추가 -> 부모 노드와 비교 반복
     * 비교 기준은 어떻게 정하느냐에 따라 다름
     * 루트 노드 까지 비교
     * <p>
     * 삭제
     * 추가 연산 반대로.
     * 루트 노드를 삭제하고 마지막에 있는 노드를 루트로 가지고와 자식 노드와 바꿈
     * 두 자식 노드 중 더 작은 것과 비교해 교환 함
     * https://st-lab.tistory.com/205
     */
    @Test
    public void 구현() {

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
