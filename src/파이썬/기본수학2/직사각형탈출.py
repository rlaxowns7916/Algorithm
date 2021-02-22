import math
x,y,w,h = map(int,input().split())

row = min(x-0,w-x)
col = min(y-0,h-y)
ans = min(row,col)

print(ans)
