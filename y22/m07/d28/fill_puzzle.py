MAXSIZE = 51


def solution(game_board, table):
    answer = -1

    puzzles_before_positioning_processing = extract_puzzle_unit(table)
    puzzles = puzzle_positioning_process(puzzles_before_positioning_processing)

    puzzle_blanks_before_positioning_processing = extract_puzzle_board_blank(game_board)
    puzzle_blanks = puzzle_positioning_process(puzzle_blanks_before_positioning_processing)

    print(puzzles)
    print(puzzle_blanks)

    return answer


def puzzle_positioning_process(puzzles):
    for puzzle in puzzles:
        x_min, y_min = MAXSIZE, MAXSIZE

        for x, y in puzzle:
            if x_min > x:
                x_min = x
            if y_min > y:
                y_min = y
        for i in range(len(puzzle)):
            puzzle[i][0] -= x_min
            puzzle[i][1] -= y_min
    return puzzles


def extract_puzzle(board, type):
    length = len(board[-1])
    puzzles = []
    for i in range(length):
        for j in range(length):
            if board[i][j] == type:
                puzzle = [[j, i]]
                q = [[j, i]]
                delta = [(0, 1), (0, -1), (1, 0), (-1, 0)]
                while q:
                    x, y = q.pop()
                    board[y][x] = -1
                    for dx, dy in delta:
                        nx = x + dx
                        ny = y + dy

                        if 0 <= nx < length and 0 <= ny < length:
                            if board[ny][nx] == type:
                                puzzle.append([nx, ny])
                                q.append([nx, ny])

                puzzles.append(puzzle)
    return puzzles


def extract_puzzle_board_blank(board):
    return extract_puzzle(board, 0)


def extract_puzzle_unit(board):
    return extract_puzzle(board, 1)


def print_board(board):
    for b in board:
        print(b)


game_board = [[1, 1, 0, 0, 1, 0], [0, 0, 1, 0, 1, 0], [0, 1, 1, 0, 0, 1], [1, 1, 0, 1, 1, 1], [1, 0, 0, 0, 1, 0], [0, 1, 1, 1, 0, 0]]
table = [[1, 0, 0, 1, 1, 0], [1, 0, 1, 0, 1, 0], [0, 1, 1, 0, 1, 1], [0, 0, 1, 0, 0, 0], [1, 1, 0, 1, 1, 0], [0, 1, 0, 0, 0, 0]]
correct_result = 14
result = solution(game_board, table)

print(correct_result == result, correct_result, result)
