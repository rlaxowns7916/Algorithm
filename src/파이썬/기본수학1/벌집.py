def getSum(n: int):
    return 1+n*(n-1)*6/2


n = int(input())
count = 1
while True:
    if n <= getSum(count):
        print(count)
        break
    count += 1
