prime = [True for i in range(10001)]


def eratos():
    global prime
    prime[0] = prime[1] = False

    for i in range(2, int(10001**0.5)+1):
        if prime[i]:
            for j in range(i*2, 10001, i):
                prime[j] = False


def isPrime(mid: int, index: int):
    if prime[mid-index] and prime[mid+index]:
        return True
    return False


testCase = int(input())
eratos()

for i in range(testCase):
    num = int(input())
    mid = num//2

    for i in range(mid):
        if isPrime(mid, i):
            print("%d %d" % (mid-i, mid+i))
            break
