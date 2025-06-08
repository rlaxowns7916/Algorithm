import sys

input = sys.stdin.readline

N, M = map(int, input().split(" "))
memory:dict[str,int] = {}

for _ in range(N):
    word = input().rstrip()
    
    if len(word) >= M:
        memory[word] = memory.get(word,0) + 1


sorted_words = sorted(memory.keys(), key= lambda x: (-memory[x], -len(x), x))
print("\n".join(sorted_words))



