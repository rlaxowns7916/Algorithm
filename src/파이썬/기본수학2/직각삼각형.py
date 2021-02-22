def check(a:int,b:int,c:int):
    if a**2 == b**2+c**2:
        print("right")
    else:
        print("wrong")

while True:
    x,y,z = map(int,input().split())

    if x == 0 and y == 0 and z == 0:
        break
    elif z > x:
        if z > y:
            check(z,x,y)
        else:
            check(y,z,x)
    elif y > z:
        if y > x:
            check(y,z,x)
        else:
            check(x,y,z)
    else:
        check(x,y,z)
        
            
