import sys

input = sys.stdin.readline

left = list(input().rstrip())  
right = []

N = int(input())

for _ in range(N):
    command = input().rstrip()

    if command[0] == 'L':
        if left:
            right.append(left.pop())
    elif command[0] == 'D':
        if right:
            left.append(right.pop())
    elif command[0] == 'B':
        if left:
            left.pop()
    elif command[0] == 'P':
        left.append(command[2])
    else:
        raise Exception()

print("".join(left + right[::-1]))