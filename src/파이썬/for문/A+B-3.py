num = int(input())

for i in reversed(range(num)):
    a,b = map(int,input().split())
    print("%d" %(a+b))