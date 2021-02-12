inputString, numSum = input(), 0
store = [["ABC", 3], ["DEF", 4], ["GHI", 5], ["JKL", 6], [
    "MNO", 7], ["PQRS", 8], ["TUV", 9], ["WXYZ", 10]]
for i in range(len(inputString)):
    for j in range(len(store)):
        if store[j][0].find(inputString[i]) != -1:
            numSum += store[j][1]
            break
print(numSum)
