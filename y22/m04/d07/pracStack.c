#include <stdio.h>
#include <stdlib.h>

#define MAX_STACK_SIZE 100

typedef int element;
typedef struct
{
    int top;
    element data[];
} StackType;

void init(StackType *s)
{
    s->top = -1;
    s->data[MAX_STACK_SIZE];
}

int isEmpty(StackType *s)
{
    if (s->top == -1)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

int isFull(StackType *s)
{
    if (s->top == MAX_STACK_SIZE - 1)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

void push(StackType *s, element e)
{
    if (isFull(s))
    {
        printf("Stack is Full");
        exit(0);
    }
    s->data[++(s->top)] = e;
}

element pop(StackType *s)
{
    if (isEmpty(s))
    {
        printf("Stack is Empty");
        exit(0);
    }
    return s->data[(s->top)--];
}

void printStack(StackType *s)
{
    for (int i = 0; i < MAX_STACK_SIZE; i++)
    {
        printf("%d", s->data[i]);
    }
    printf("\n");
}

int main()
{
    StackType s;
    init(&s);
    push(&s, 1);
    push(&s, 2);
    push(&s, 3);
    printStack(&s);
    pop(&s);
    pop(&s);
    pop(&s);
    printStack(&s);

    return 0;
}