# 2022.04.20.

# ADT
## 스택 
```
top : 값이 들어가고 나갈 인덱스
data[MAX_SIZE] : 값이 저장 될 배열

init() : 인덱스 초기화
    top = -1    

isEmpty() : 스택이 비어있는지 확인
    return top == -1
    
isFull() : 스택이 꽉 찼는지 확인
    return top == MAX_SIZE - 1
    
push(element) : 스택에 데이터 삽입
    if isFull
        "Stack is Full"
        exit
    else
        data[++top] = element
        
pop() : 스택에서 데이터 삭제
    if isEmpty
        "Stack is Empty"
        exit
    else
        return data[top--]

peek() : 스택에서 데이터 조회
    if isEmpty
        "Stack is Empty"
    else
        return data[top]
```

## 원형 큐
```
front : 가장 먼저 들어온 값, 가장 빨리 나갈 인덱스
rear : 가장 나중에 들어온 값, 다음에 들어 올 인덱스
data[MAX_SIZE] : 값이 저장 될 배열

init() : 인덱스 초기화
    front = 0
    rear = 0

isEmpty() : 큐가 비어있는지 확인
    return front == rear
    
isFull() : 큐가 꽉 찼는지 확인
    return front % MAX_SIZE == (rear + 1) % MAX_SIZE
    
push(element) : 큐에 데이터 삽입
    if isFull
        "Queue is Full"
        exit
    else
        data[++rear % MAX_SIZE] = element
        
pop() : 큐에서 데이터 삭제
    if isEmpty
        "Queue is Empty"
        exit
    else
        return data[++front % MAX_SIZE]

peek() : 큐에서 데이터 조회
    if isEmpty
        "Queue is Empty"
    else
        return data[(front+1) % MAX_SIZE]
```


