N, M = tuple(map(int, input().split(" ")))

pocketmon_holder_by_index = {}
pocketmon_holder_by_name = {}

for i in range(N):
    pocketmon = input()
    index = str(i+1)
    pocketmon_holder_by_index[index] = pocketmon
    pocketmon_holder_by_name[pocketmon] = index
    
answer=[]
for j in range(M):
    question = input()
    if question.isnumeric():
        answer.append(pocketmon_holder_by_index[question])
    else:
        answer.append(pocketmon_holder_by_name[question])
        
print("\n".join(answer))

    