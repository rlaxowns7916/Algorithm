primeNum = [True for i in range(123456*2+1)]
primeNum[0] = primeNum[1] = False
while True:
    n = int(input())
    if n == 0:
        break
    count = 0
    for i in range(2, int((2*n)**0.5)+1):
        if primeNum[i]:
            for j in range(i*2, 2*n+1, i):
                primeNum[j] = False
    for i in range(n+1, 2*n+1):
        if primeNum[i]:
            count += 1
    print(count)
