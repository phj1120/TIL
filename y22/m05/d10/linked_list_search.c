// Ư���� ���� Ž���ϴ� �Լ�

#include <stdio.h>
#include <stdlib.h>

typedef int element;
typedef struct ListNode { 	// ��� Ÿ��
	element data;
	struct ListNode* link;
} ListNode;

// ���� ó�� �Լ�
void error(char* message)
{
	fprintf(stderr, "%s\n", message);
	exit(1);
}

// �� �տ� ���ο� ��� �߰�
ListNode* insert_first(ListNode* head, element value)
{
	ListNode* p = (ListNode*)malloc(sizeof(ListNode));

	if (p != NULL) {
		p->data = value;
		p->link = head;
		head = p;
	}
	return head;	// ���� �߰� �� ����� ������ ��ȯ
}

// ��� pre �ڿ� ���ο� ��� ����
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

// �� ���� ��� ����
ListNode* delete_first(ListNode* head)
{
	ListNode* removed;
	if (head == NULL) return NULL;
	removed = head;
	head = removed->link;
	free(removed);
	return head; // ���� �۾� �� �� ���� �� ����� ������ ��ȯ
}

// pre�� ����Ű�� ����� ���� ��带 �����Ѵ�. 
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


// ��尪 Ž�� �˰���
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
		printf("����Ʈ�� %d ����\n", x);
	else
		printf("����Ʈ�� %d ����\n", x);
}

// �׽�Ʈ ���α׷�
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