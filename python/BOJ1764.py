N,M = map(int, input().split(" "))

ever_seen: set = {input() for item in range(N)}
ever_heard: set = {input() for iterm in range(M)}
ever_seen_and_ever_heard = sorted(ever_seen & ever_heard)

print(len(ever_seen_and_ever_heard))
print("\n".join(ever_seen_and_ever_heard))