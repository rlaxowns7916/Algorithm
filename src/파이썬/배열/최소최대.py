num = int(input())
list = list(map(int, input().split()))
max = -1000001
min = 1000001
for i in range(num):
    if max < list[i]:
        max = list[i]
    if min > list[i]:
        min = list[i]
print("%d %d" % (min, max))
