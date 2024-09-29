results = []
N = int(input())
cards = set(map(int,input().split(" ")))

M = int(input())
find = list(map(int,input().split(" ")))

for i in range(M):
    if find[i] in cards:
        results.append("1")
    else:
        results.append("0")

print (" ".join(results))