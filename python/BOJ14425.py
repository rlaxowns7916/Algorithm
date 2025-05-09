N, M = map(int, input().split())

counter: int = 0
base: set = { input() for _ in range(N)}
counter: int = sum(1 if input() in base else 0 for _ in range(M))

print(counter)