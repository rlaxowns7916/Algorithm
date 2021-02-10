import math
N = int(input())
numList = list(map(int, input().split()))
numMax = max(numList)
numSum = 0

for i in range(len(numList)):
    numSum += round(numList[i]/numMax*100, 2)
print(numSum/N)
