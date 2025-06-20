N, M = map(int,input().split(" "))
memories = {k: v for _ in range(N) for k, v in [input().split()]}
print("\n".join( memories[input()] for _ in range(M)))