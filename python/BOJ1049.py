N,  M = map(int, input().split(" "))

maxIndex = 6 * (N // 6 + 1)
package=1001
single=1001
result= [1001 * 1000] * (maxIndex + 1)

for _ in range(M):
    p, s = map(int, input().split(" "))
    
    package = min(package, p)
    single = min(single, s)

result[0] = 0
for index in range(1, maxIndex+1):
    if index - 6 >=0 :
        result[index]  = min(result[index], result[index-6] + package)
    result[index] = min(result[index], result[index-1]+single)


print(min(result[N], result[maxIndex]))
        