inputs = [int(ch) for ch in input()]
phase = 0 if len(inputs) == 1 else 1
y = sum(inputs)

while y >= 10:
    phase += 1
    y = sum(int(ch) for ch in str(y))

print(phase)
print("YES" if y % 3 == 0 else "NO")