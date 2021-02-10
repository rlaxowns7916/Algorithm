num = 1
for i in range(3):
    num *= int(input())

num = str(num)
for i in range(10):
    count = num.count(str(i))
    if count == -1:
        continue
    else:
        print(count)
