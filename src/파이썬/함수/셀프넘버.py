bitmask = 0
def checkSelfNum(n:int):
    num = n
    numStr = str(n)
    global bitmask
    for i in range(len(numStr)):
        num += int(numStr[i])
    if bitmask & 1<<num == 0:
        bitmask |= 1<<num

for i in range(1,10001):
    checkSelfNum(i)
    if bitmask & 1 << i == 0:
        print(i)

