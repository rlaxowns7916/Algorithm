t = int(input())

for i in range(t):
    n, inputString = input().split()
    for j in range(len(inputString)):
        n = int(n)
        print(n*inputString[j], end="")
    print()
