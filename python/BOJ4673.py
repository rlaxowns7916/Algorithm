exclude: set[int] = set()
result: set[int] = set(range(1,10001))

for i in range(1,10001):
    value = i
    for j in str(value):
        i += int(j)
    exclude.add(i)
    
print("\n".join(map(str,sorted(result - exclude))))