n = int(input())

if n < 100:
    print(n)
else:
    count = 99
    for i in range(100,n+1):
        string = str(i)
        length = len(string)
        diff = int(string[0]) - int(string[1])
        flag = True
        for j in range(1,length-1):
            if diff != int(string[j])-int(string[j+1]):
                flag=False
                break
        if(flag):
            count+=1
    print(count)
