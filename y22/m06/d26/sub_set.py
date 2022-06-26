full_list = [1, 2, 3, 4, 5]
sub_list = [1, 2]

print(full_list < sub_list)
print(full_list > sub_list)

print([3] < [1, 2])
print([1, 2] <= [1, 2, 3, 4, 5])
print({0, 1} <= {1, 2, 3, 4, 5})

print({0, 1}.issubset({1, 2, 3, 4, 5}))

print(type({0, 1}))

print({0, 1} <= {0, 1, 2})

print({0, 1}.issubset({0, 1, 2}))
