MAXSIZE = 51
MINSIZE = -1


def solution(game_board, table):
    answer = -1

    puzzles_before_positioning_processing = extract_puzzle_unit(table)
    puzzles = puzzle_positioning_process(puzzles_before_positioning_processing)

    puzzle_blanks_before_positioning_processing = extract_puzzle_board_blank(game_board)
    puzzle_blanks = puzzle_positioning_process(puzzle_blanks_before_positioning_processing)

    puzzle_lists = []
    for puzzle in puzzles:
        puzzle_list = puzzle_to_puzzle_list(puzzle)
        puzzle_lists.append(puzzle_list)

    for puzzle_blank in puzzle_blanks:
        puzzle_blank_list = puzzle_to_puzzle_list(puzzle_blank)
        puzzle_blank_lists = puzzle_rotation_for_angle(puzzle_blank_list)
        for puzzle_blank_list in puzzle_blank_lists:
            for idx, puzzle_list in enumerate(puzzle_lists):
                if puzzle_blank_list == puzzle_list:
                    print(puzzle_lists)
                    print(puzzle_list, ' / ', puzzle_blank_list)
                    puzzle_lists.pop(idx)
                    break

    return answer


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


def puzzle_to_puzzle_list(puzzle):
    x_max, y_max = MINSIZE, MINSIZE
    for x, y in puzzle:
        if x_max < x:
            x_max = x
        if y_max < y:
            y_max = y
    puzzle_list = [[0 for _ in range(x_max + 1)] for _ in range(y_max + 1)]

    for x, y in puzzle:
        puzzle_list[y][x] = 1

    return puzzle_list


def puzzle_rotation_for_angle(puzzle):
    puzzles = [puzzle]
    for i in range(3):
        puzzle = puzzle_list_turn_right_90(puzzle)
        puzzles.append(puzzle)
    return puzzles


def puzzle_list_turn_right_90(puzzle_list):
    original_x_len = len(puzzle_list[-1])
    original_y_len = len(puzzle_list)
    turn_puzzle_list = [[0 for _ in range(original_y_len)] for _ in range(original_x_len)]

    for y in range(original_y_len):
        for x in range(original_x_len):
            turn_puzzle_list[x][original_y_len - y - 1] = puzzle_list[y][x]

    return turn_puzzle_list


def print_board(board):
    for b in board:
        print(b)


game_board = [[1, 1, 0, 0, 1, 0], [0, 0, 1, 0, 1, 0], [0, 1, 1, 0, 0, 1], [1, 1, 0, 1, 1, 1], [1, 0, 0, 0, 1, 0], [0, 1, 1, 1, 0, 0]]
table = [[1, 0, 0, 1, 1, 0], [1, 0, 1, 0, 1, 0], [0, 1, 1, 0, 1, 1], [0, 0, 1, 0, 0, 0], [1, 1, 0, 1, 1, 0], [0, 1, 0, 0, 0, 0]]
correct_result = 14
result = solution(game_board, table)

print(correct_result == result, correct_result, result)
