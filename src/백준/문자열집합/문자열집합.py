command = input()
(N,M) = tuple(map(int,command.split(" ")[:2]))

S = set()
counter = 0

for i in range(N):
    returns = S.add(input())

for j in range(M):
    if input() in S:
        counter += 1

print(counter)