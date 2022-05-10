// 특정한 값을 탐색하는 함수

#include <stdio.h>
#include <stdlib.h>

typedef int element;
typedef struct ListNode { 	// 노드 타입
	element data;
	struct ListNode* link;
} ListNode;

// 오류 처리 함수
void error(char* message)
{
	fprintf(stderr, "%s\n", message);
	exit(1);
}

// 맨 앞에 새로운 노드 추가
ListNode* insert_first(ListNode* head, element value)
{
	ListNode* p = (ListNode*)malloc(sizeof(ListNode));

	if (p != NULL) {
		p->data = value;
		p->link = head;
		head = p;
	}
	return head;	// 새로 추가 된 노드의 포인터 반환
}

// 노드 pre 뒤에 새로운 노드 삽입
ListNode* insert(ListNode* head, ListNode* pre, element value)
{
	ListNode* p = (ListNode*)malloc(sizeof(ListNode));

	if (p != NULL) {
		p->data = value;
		p->link = pre->link;
		pre->link = p;
	}
	return head;
}

// 맨 앞의 노드 삭제
ListNode* delete_first(ListNode* head)
{
	ListNode* removed;
	if (head == NULL) return NULL;
	removed = head;
	head = removed->link;
	free(removed);
	return head; // 삭제 작업 후 맨 앞이 된 헤드의 포인터 반환
}

// pre가 가리키는 노드의 다음 노드를 삭제한다. 
ListNode* delete(ListNode* head, ListNode* pre)
{
	ListNode* removed;
	removed = pre->link;
	pre->link = removed->link;
	free(removed);
	return head;
}

void print_list(ListNode* head)
{
	for (ListNode* p = head; p != NULL; p = p->link)
		printf("%d->", p->data);
	printf("NULL \n");
}


// 노드값 탐색 알고리즘
ListNode* search_list(ListNode* head, element x) {
	ListNode* p = head;

	while (p!=NULL){
		if (p->data == x) return p;
		p = p->link;
	}
	return NULL;
}

void print_search_result(ListNode* head, element x) {
	if (search_list(head, x) == NULL)
		printf("리스트에 %d 없음\n", x);
	else
		printf("리스트에 %d 있음\n", x);
}

// 테스트 프로그램
int main(void)
{
	ListNode* head = NULL;

	head = insert_first(head, 10);
	head = insert_first(head, 20);
	head = insert_first(head, 30);
	print_list(head);

	print_search_result(head, 10);
	print_search_result(head, 40);

	return 0;
}