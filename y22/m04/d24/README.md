# 2022.04.24.

이진 탐색 아이디어는 간단하지만

제로베이스에서 구현하기 생각보다 쉽지 않음

코테에 단골로 나오니까 여러번 쳐보고 익혀두자

탐색 범위가 2,000 만을 넘는 경우 이진 탐색으로 접근해보기

처리해야할 값이 천 만 단위로 넘어가면 O(logN) 시간 복잡도를 가지는 알고리즘 짜야함

# 트리 자료 구조

이진 탐색을 사용하려면 데이터가 정렬되어 있어야 함

DB 는 트리구조를 이용해 항상 데이터 정렬 되어 있음

트리의 특징

* 트리의 최상단 : 루트 노드
* 트리의 최하단 : 단말 노드
* 부모 노드와 자식 노드의 관계로 표현
* 트리에서 일부를 떼어내도 트리 구조 (서브 트리)
* 파일 시스템과 같이 계층적이고 정렬 된 데이터 다루기에 적합

큰 데이터 처리 하는 소프트웨어는 트리 구조로 데이터 저장 해

이진 탐색으로 빠르게 탐색

트리 구조는 항상 이진 탐색이 가능?

# 이진 탐색 트리

트리라고 다 되는거 아님 이진 탐색 트리의 경우 가능

* 부모 노드 보다 왼쪽 자식 노드가 작다
* 부모 노드 보다 오른쪽 자식 노드가 크다

왼쪽 자식 노드 < 부모 노드 < 오른쪽 자식 노드

이건 알고리즘이라기 보다 자료 구조에 가깝고 출제 빈도가 낮아 구현 패스

# Python print 줄 넘김 제거

print("hi") 은 print("hi", end="\n") 와 동일

print("hi", end="") 를 하면 줄 넘김 제거 가능

# 부품 찾기 문제

이진 탐색 구현할 줄 알면 쉽게 해결 가능

이진 탐색 뿐만 아니라 계수 정렬, 집합자료형 으로도 효율적으로 풀 수 있음