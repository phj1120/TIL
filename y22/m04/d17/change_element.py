nk = input()
a_str = input()
b_str = input()

k = nk.split(" ")[1]
a_arr = a_str.split(" ")
b_arr = b_str.split(" ")

for i in range(int(k)):
    a_idx = int(a_arr.index(min(a_arr)))
    b_idx = int(b_arr.index(max(b_arr)))
    a_arr[a_idx], b_arr[b_idx] = b_arr[b_idx], a_arr[a_idx]

sum = 0
for i in range(len(a_arr)):
    sum += int(a_arr[i])
print(sum)
