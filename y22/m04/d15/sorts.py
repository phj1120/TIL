# 오름차순

# 선택 정렬
# 직접 구현
arr = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(0, len(arr)):  # 탐색 반복
    min_idx = len(arr) + 1
    min_val = 10
    for j in range(i, len(arr)):  # 탐색 범위 지정
        if min_val > arr[j]:
            min_idx = j
            min_val = arr[j]
    arr[i], arr[min_idx] = arr[min_idx], arr[i]  # 스와프

print("선택 정렬 ", arr)

# Sol
arr = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(arr)):
    min_idx = i  # 가장 작은 원소의 인덱스
    for j in range(i+1, len(arr)):
        if arr[min_idx] > arr[j]:
            min_idx = j
        arr[i], arr[min_idx] = arr[min_idx], arr[i]

print("선택 정렬 sol ", arr)


# 삽입 정렬
# 좌우의 값을 비교해서 사이 값에 대입해야 한다는 생각에 구현하지 못 했음
# 내 아이디어의 경우 처음의 데이터는 좌우 비교를 못해 따로 설정해 줘야하는데 이건 아니라 생각
# 보다 큰 값, 보다 작은 값으로 반복해서 비교하면 됐음

# Sol
arr = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(1, len(arr)):
    for j in range(i, 0, -1):
        if arr[j] < arr[j-1]:
            arr[j], arr[j-1] = arr[j-1], arr[j]
        else:
            break

print("삽입 정렬 Sol", arr)
