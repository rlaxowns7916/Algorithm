import math

n = int(input())
nums = list(map(int,input().split()))
visit = [False for i in range(max(nums)+1)]
count = 0

for i in range(2,max(nums)+1):
    flag = True
    for j in range(2,i):
        if j > math.sqrt(i):
            break
        elif visit[j] == False:
            continue
        elif i % j == 0:
            flag = False
            break
    if flag:
        visit[i]=True


for i in range(n):
    if visit[nums[i]] == True : 
        count+=1
print(count)