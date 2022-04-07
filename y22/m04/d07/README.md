# 2022.04.07.

큐를 드디어 구현했다.

내용은 이해 했었는데 구현이 맘처럼 안 됐었는데 익숙해지니까 됐다.

익숙하지 않아서 그렇지 그리 어려운 개념도 아니었다.

다른 것도 그런것 같다. 내가 안 익숙해서 혼자 쫄아있어서 그러지 어떻게든 다 할 수 있는거다.

어제 이것도 이해 못 한다고 멍청 하다고 자책을 했었다.

자책할 것은 내 머리가 아니라 조금이라도 빨리 시작하지 않은 거다.

안 된다고 너무 얽메이지 말고 계속 나가야겠다.

내일은 DFS, BFS 문제 풀어봐야겠다.

얼른 이코테 다 풀고 백준 티어 도전 해야지

```
    #include<stdio.h>
    #include<stdlib.h>
    
    #define MAX_QUEUE_SIZE 5
    
    typedef int element;
    typedef struct {
        int front;
        int rear;
        element data[MAX_QUEUE_SIZE];
    }QueueType;
    
    void init(QueueType* q) {
        q->front = 0;
        q->rear = 0;
    }
    
    int isEmpty(QueueType* q) {
        return q->front == q->rear;
    }
    
    int isFull(QueueType* q) {
        return (q->rear + 1) % MAX_QUEUE_SIZE == q->front % MAX_QUEUE_SIZE;
    }
    
    void enqueue(QueueType* q, element e) {
        if (isFull(q)) {
            printf("Queue is Full");
            exit(1);
        }
        q->rear = (q->rear + 1) % MAX_QUEUE_SIZE;
        q->data[q->rear] = e;
    }
    
    element dequeue(QueueType* q) {
        if (isEmpty(q)) {
            printf("Queue is Empty");
            exit(1);
        }
        q->front = (q->front + 1) % MAX_QUEUE_SIZE;
        return q->data[q->front];
    }
    
    void printQueue(QueueType* q)
    {
        printf("QUEUE(front=%d rear=%d) = ", q->front, q->rear);
        if (!isEmpty(q)) {
            int i = q->front;
            do {
                i = (i + 1) % (MAX_QUEUE_SIZE);
                printf("%d | ", q->data[i]);
                if (i == q->rear)
                    break;
            } while (i != q->front);
        }
        printf("\n");
    }
    
    int main() {
        QueueType q;
        init(&q);
        enqueue(&q, 1);
        printQueue(&q);
        enqueue(&q, 2);
        printQueue(&q);
        enqueue(&q, 3);
        printQueue(&q);
    
        dequeue(&q);
        printQueue(&q);
        dequeue(&q);
        printQueue(&q);
        dequeue(&q);
        printQueue(&q);
    
        enqueue(&q, 4);
        printQueue(&q);
        enqueue(&q, 5);
        printQueue(&q);
        enqueue(&q, 6);
        printQueue(&q);
    
        dequeue(&q);
        printQueue(&q);
        dequeue(&q);
        printQueue(&q);
        dequeue(&q);
        printQueue(&q);
    
        enqueue(&q, 7);
        printQueue(&q);
        enqueue(&q, 8);
        printQueue(&q);
        enqueue(&q, 9);
        printQueue(&q);
        
        dequeue(&q);
        printQueue(&q);
        dequeue(&q);
        printQueue(&q);
        dequeue(&q);
        printQueue(&q);
    }
```