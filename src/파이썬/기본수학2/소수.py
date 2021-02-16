import math

M = int(input())
N = int(input())
check = [False for i in range(N+1)]
primeList=[]

for i in range(2,N+1):
    flag = True
    for j in range(i):
        if check[j] == True:
            if j > math.sqrt(i):
                break
            elif i % j == 0:
                flag = False
                break
    if flag:
        check[i] = True

primeList = [i for i in range(M,N+1) if check[i] == True] 
if len(primeList) == 0:
    print(-1)
else:
    print(sum(primeList))
    print(min(primeList))

