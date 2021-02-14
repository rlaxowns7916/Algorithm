testCase = int(input())
for i in range(testCase):
    row = []
    floor = int(input())
    room = int(input())

    for j in range(floor+1):
        if j == 0:
            column = []
            for k in range(room+1):
                column.append(k)
            row.append(column)
        else:
            column = []
            sum = 0
            for k in range(room+1):
                sum = 0
                for l in range(k+1):
                    sum += row[j-1][l]
                column.append(sum)
            row.append(column)
    print(row[floor][room])
