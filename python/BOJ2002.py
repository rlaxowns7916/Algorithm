N = int(input())
inputs = {input(): idx for idx in range(N)}
outputs = [input() for _ in range(N)]
count = 0

for i in range(N):
    for j in range(i+1, N):
        if inputs[outputs[i]] > inputs[outputs[j]]:
            count += 1
            break

print(count)