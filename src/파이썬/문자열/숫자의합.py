N = int(input())
numString = input()
numSum = 0

for i in range(len(numString)):
    numSum += int(numString[i])
print(numSum)
