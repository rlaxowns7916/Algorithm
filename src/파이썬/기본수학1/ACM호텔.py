testCase = int(input())

for i in range(testCase):
    H, W, N = map(int, input().split())
    floor = N % H
    room = N//H+1
    if floor == 0:
        floor = H
        room -= 1
    if room >= 10:
        print("%d%d" % (floor, room))
    else:
        print("%d0%d" % (floor, room))
