print('java 의 for-each 처럼 사용')

int_list = [0, 1, 2, 3, 4, 5, 6]

print(len(int_list))
for idx, num in enumerate(int_list):
    print(idx)
    print(int_list)
    int_list.remove(num)
    print(int_list)
    # idx -= 1 # 안 먹힘

print('자바의 기본 for 처럼 사용')

int_list = [0, 1, 2, 3, 4, 5, 6]
print(len(int_list))

for idx in range(len(int_list)):
    # int_list.remove(int_list[idx])
    print(idx, int_list)
    # idx -= 1 # 안 먹힘
