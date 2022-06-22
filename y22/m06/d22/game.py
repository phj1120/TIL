def solution(m, n, board):
    # 블록 내림을 편하게 하기 위해 가로 세로 변경
    m, n = n, m
    change_board = []
    for i in range(m):
        row = []
        for j in range(n):
            row.append(board[j][i])
        change_board += [row]

    total_remove_cnt = 0
    while True:
        new_board, remove_cnt = round(m, n, change_board)
        if remove_cnt == 0: break
        total_remove_cnt += remove_cnt
        change_board = new_board[:]
    return total_remove_cnt


def round(m, n, board):
    same = []
    for i in range(0, m - 1):
        for j in range(0, n - 1):
            if ('' != board[i][j] == board[i][j + 1] == board[i + 1][j] == board[i + 1][j + 1]):
                if ([i, j]) not in same: same.append([i, j])
                if ([i, j + 1]) not in same: same.append([i, j + 1])
                if ([i + 1, j]) not in same: same.append([i + 1, j])
                if ([i + 1, j + 1]) not in same: same.append([i + 1, j + 1])

    new_board = []
    for b in board:
        new_board.append(list(b))

    for i, j in same:
        new_board[i][j] = ''

    for idx, row in enumerate(new_board):
        length = len(row)
        for i in range(length):
            if row[i] != '':
                continue
            for j in range(i, 0, -1):
                if row[j - 1] == '':
                    continue
                row[j], row[j - 1] = row[j - 1], row[j]
        new_board[idx] = row
    remove_cnt = len(same)

    return new_board, remove_cnt
