listX=[]
listY=[]
ansX =-1
ansY=-1
for i in range(3):
    x,y = map(int,input().split())
    listX.append(x)
    listY.append(y)
for i in range(3):
    if ansX != -1 and ansY != -1:
        break
    if listX.count(listX[i]) == 1:
        ansX = listX[i]
    if listY.count(listY[i]) == 1:
        ansY = listY[i]
print("%d %d" %(ansX,ansY))