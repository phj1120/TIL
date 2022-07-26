def solution(game_board, table):
    answer = -1
    puzzles = extract_puzzle(table)
    print(puzzles)
    print_board(table)

    return answer


def extract_puzzle(board):
    length = len(board[-1])
    puzzles = []
    for i in range(length):
        for j in range(length):
            if board[i][j] == 1:
                puzzle = []
                q = [(j, i)]
                delta = [(0, 1), (0, -1), (1, 0), (-1, 0)]
                while q:
                    x, y = q.pop()
                    for dx, dy in delta:
                        nx = x + dx
                        ny = y + dy
                        if 0 <= nx < length and 0 <= ny < length:
                            if board[ny][nx] == 1:
                                puzzle.append((nx, ny))
                                q.append((nx, ny))
                                board[ny][nx] = -1
                puzzles.append(puzzle)
    return puzzles


def print_board(board):
    for b in board:
        print(b)


game_board = [[1, 1, 0, 0, 1, 0], [0, 0, 1, 0, 1, 0], [0, 1, 1, 0, 0, 1], [1, 1, 0, 1, 1, 1], [1, 0, 0, 0, 1, 0], [0, 1, 1, 1, 0, 0]]
table = [[1, 0, 0, 1, 1, 0], [1, 0, 1, 0, 1, 0], [0, 1, 1, 0, 1, 1], [0, 0, 1, 0, 0, 0], [1, 1, 0, 1, 1, 0], [0, 1, 0, 0, 0, 0]]
correct_result = 14
result = solution(game_board, table)

print(correct_result == result, correct_result, result)
