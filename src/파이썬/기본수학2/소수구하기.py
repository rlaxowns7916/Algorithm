from sys import stdin

M, N = map(int, stdin.readline().split())
primeNums = [True for i in range(N+1)]
primeNums[1] = False

for i in range(2, int(N**0.5)+1):
    if primeNums[i]:
        for j in range(i*2, N+1, i):
            primeNums[j] = False

print(('\n'.join(str(i) for i in range(M, N+1) if primeNums[i])))
