def getSum(n: int):
    return n*(n+1)/2


n = int(input())
remain = 0
count = 1
denominator = 1
numerator = 1
findNum = 0

while True:
    findNum = getSum(count)
    if n <= findNum:
        remain = n - getSum(count-1)
        denominator = count-remain+1
        numerator = remain

        if count % 2 == 0:
            print("%d/%d" % (numerator, denominator))
        else:
            print("%d/%d" % (denominator, numerator))
        break
    count += 1
