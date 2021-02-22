import math
n = int(input())
dp = [n for i in range(n+1)]

dp[3] = 1
if n >= 5:
    dp[5]=1
    for i in range(6,n+1):
         temp = min(dp[i-3],dp[i-5])
         if temp != n:
             dp[i] = temp+1

if dp[n] == n:
    print(-1)
else:
    print(dp[n])
    