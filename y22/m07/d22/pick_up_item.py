def solution(rectangle, characterX, characterY, itemX, itemY):
    MAXNUM = 102
    board = [[0 for j in range(MAXNUM)] for i in range(MAXNUM)]

    # 사각형 1로 채우기 (테두리+내부)
    for left_down_x, left_down_y, right_up_x, right_up_y in rectangle:
        for i in range(2 * left_down_y, 2 * right_up_y + 1):
            for j in range(2 * left_down_x, 2 * right_up_x + 1):
                board[i][j] = 1

    # 사각형 0으로 채우기 (내부)
    for left_down_x, left_down_y, right_up_x, right_up_y in rectangle:
        for i in range(2 * left_down_y + 1, 2 * right_up_y):
            for j in range(2 * left_down_x + 1, 2 * right_up_x):
                board[i][j] = 0

    # 테두리 따라가기
    characterX *= 2
    characterY *= 2
    itemX *= 2
    itemY *= 2

    stack = [(0, characterY, characterX)]
    while stack:
        w, characterY, characterX = stack.pop(0)
        board[characterY][characterX] = -1  # 방문 시 : -1

        if board[itemY][itemX] < 0:  # 현재 위치가 아이템 위치일 경우
            return w // 2

        # 상 하 좌 우
        for dr, dc in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            if board[characterY + dr][characterX + dc] > 0:  # 현재 위치가 테두리인 경우
                stack.append((w + 1, characterY + dr, characterX + dc))


rectangle = [[1, 1, 7, 4], [3, 2, 5, 5], [4, 3, 6, 9], [2, 6, 8, 8]]
character_x = 1
character_y = 3
item_x = 7
item_y = 8
result = 17
my_result = solution(rectangle, character_x, character_y, item_x, item_y)

print(result == my_result)
print('Correct Result : ', result)
print('   My Result   : ', my_result)
