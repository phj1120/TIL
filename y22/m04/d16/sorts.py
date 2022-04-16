arr = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]


def quick_sort(array):
    while True:
        pivot = 0
        over = -1
        under = -1
        print("\narray : ", array)

        for i in range(1, len(array), 1):
            if array[pivot] < array[i]:
                over = i
                break

        for i in range(len(array) - 1, 0, -1):
            if array[pivot] > array[i]:
                under = i
                break

        if over == under:
            print("hereqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq")
            break

        if under == -1 or over == -1:
            print("over", over, "under", under)
            break

        if over < under:
            array[under], array[over] = array[over], array[under]
            continue

        if over > under:
            array[under], array[pivot] = array[pivot], array[under]
            break



    if len(array) > 2:
        left = quick_sort(array[:under])
        print("left", left)
        right = quick_sort(array[under:])
        print("right", right)
        array = left + right

    return array


print(quick_sort(arr))
