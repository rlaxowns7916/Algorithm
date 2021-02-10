import math
N = int(input())

for i in range(N):
    numList = list(map(int, input().split()))
    mean = 0
    cnt = 0
    for j in range(1, len(numList)):
        mean += numList[j]
    mean /= numList[0]

    for j in range(1, len(numList)):
        if numList[j] > mean:
            cnt += 1
    print(format(round(cnt/numList[0]*100, 3), ".3f"), end="%\n")
