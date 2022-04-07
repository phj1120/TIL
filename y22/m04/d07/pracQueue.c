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