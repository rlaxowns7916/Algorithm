command = input()
total_sum = 0
split_by_minus_list = command.split("-")

for index,split_by_minus in enumerate(split_by_minus_list) :
    partial_sum  = 0

    split_by_plus_list = split_by_minus.split("+")
    for split_by_plus in split_by_plus_list:
        partial_sum += int(split_by_plus)

    if index == 0:
        total_sum += partial_sum
    else:
        total_sum -= partial_sum

print(total_sum)