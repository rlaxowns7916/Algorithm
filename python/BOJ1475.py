from collections import defaultdict

n:str = input()
result=0
counter:dict[int,int] = defaultdict(int)

for chr in n:
    counter[chr] += 1

result = (counter['6'] + counter['9'] + 1) // 2
for index in range(10):
    if index == 6 or index == 9:
        continue
    result = max(result,counter[str(index)])

print(result)
