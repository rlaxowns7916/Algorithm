A, B = map(int, input().split())

A_group = set(input().split())
B_group = set(input().split())

only_in_A = A_group - B_group
only_in_B = B_group - A_group

result = len(only_in_A) + len(only_in_B)
print(result)