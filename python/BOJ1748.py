N = int(input())

start= 0
len=1
result = 0

while pow(10, start+1) <= N:
    result += ((pow(10,start+1) - pow(10,start))) * len
    start += 1
    len += 1
    
    
result += (N - pow(10,start)+1) * len
print(result)