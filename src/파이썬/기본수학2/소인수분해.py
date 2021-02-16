import math
n = int(input())
num=2
while True:
    mid = int(math.sqrt(n))
    if n  == 1:
        break
    elif num > mid:
        print(n)
        break
    while n % num == 0:
        print(num)
        n //= num
    num +=1
