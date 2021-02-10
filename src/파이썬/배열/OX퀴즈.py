N = int(input())

for i in range(N):
    cnt = 1
    score = 0
    string = input()
    for j in range(len(string)):
        if string[j] == 'O':
            score += cnt
            cnt += 1
        else:
            cnt = 1
    print(score)
