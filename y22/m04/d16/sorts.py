arr = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]
arr = [5, 6, 9, 0, 3, 1, 6, 2, 4, 8]
arr = list("12324124540932580903350592502358032")


def quick_sort(array):
    while True:
        pivot = 0
        over = -1
        under = -1

        for i in range(1, len(array), 1):
            if array[pivot] < array[i]:
                over = i
                break

        for i in range(len(array) - 1, 0, -1):
            if array[pivot] > array[i]:
                under = i
                break

        if over == -1:
            array[under], array[pivot] = array[pivot], array[under]
            break

        if under == -1:
            under = 1
            break

        if over < under:
            array[under], array[over] = array[over], array[under]
            continue

        if over > under:
            array[under], array[pivot] = array[pivot], array[under]
            break

    if len(array) > 2:
        left = quick_sort(array[:under])
        right = quick_sort(array[under:])
        array = left + right

    return array


print(quick_sort(arr))
