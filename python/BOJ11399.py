N = int(input())
times = sorted(map(int, input().split()))

total = 0
current = 0

for time in times:
    current += time
    total += current

print(total)