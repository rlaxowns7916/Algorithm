A, B, K = map(int, input().split())
diff = A-B
day = (K-A)//diff
total = diff*day

while True:
    day += 1
    total += A
    if total >= K:
        print(day)
        break
