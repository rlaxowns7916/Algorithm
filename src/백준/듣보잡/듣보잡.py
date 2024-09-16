(N,M) = tuple(map(int,input().split(" ")[:2]))

ever_seen = set()
ever_heard = set()

for i in range(N):
    ever_seen.add(input())

for j in range(M):
    ever_heard.add(input())


ever_seen_and_heard = sorted(list(ever_seen & ever_heard))

print(len(ever_seen_and_heard))
print("\n".join(ever_seen_and_heard))

