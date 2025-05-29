S = input()
result = set()

for length in range(1, len(S) + 1):
    for start in range(len(S) - length + 1):  
        result.add(S[start:start + length])

print(len(result))