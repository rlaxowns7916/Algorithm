N = int(input())
alphabet = "abcdefghijklmnopqrstuvwxyz"
numSum = 0
for i in range(N):
    bitmask = 0
    inputString = input()
    flag = True
    if len(inputString) == 1:
        numSum += 1
    else:
        for j in range(len(inputString)):
            index = alphabet.find(inputString[j])
            if bitmask & 1 << index == 0:
                bitmask |= 1 << index
            else:
                if inputString[j] != inputString[j-1]:
                    flag = False
                    break
        if flag:
            numSum += 1
print(numSum)
