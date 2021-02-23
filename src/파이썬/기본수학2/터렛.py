import math


class Turret:
    def __init__(self, x: int, y: int, dist: int):
        self.x = x
        self.y = y
        self.dist = dist


testCase = int(input())


for i in range(testCase):
    inputs = list(map(int, input().split()))
    cho = Turret(inputs[0]+10000, inputs[1]+10000, inputs[2])
    baek = Turret(inputs[3]+10000, inputs[4]+10000, inputs[5])

    diffX = abs(cho.x-baek.x)
    diffY = abs(cho.y-baek.y)
    dist = (diffX**2 + diffY**2)**0.5

    if cho.dist == baek.dist and diffX == 0 and diffY == 0:
        print(-1)
    elif dist == cho.dist+baek.dist or (dist == abs(cho.dist - baek.dist) and dist != 0):
        print(1)
    elif dist < cho.dist+baek.dist and dist > abs(cho.dist - baek.dist):
        print(2)
    else:
        print(0)
