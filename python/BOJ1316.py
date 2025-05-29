N: int = int(input())
answer = N

for _ in range(N):
    word: str = input()
    checker = set()
    checker.add(word[0])
    for index in range(1, len(word)):
        if word[index-1] != word[index] and word[index] in checker:
            answer -= 1
            break
        checker.add(word[index])

print(answer)
            