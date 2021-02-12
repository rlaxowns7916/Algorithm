inputString = input()
count = len(inputString)
for i in range(len(inputString)):
    if inputString[i] == '-' or inputString[i] == '=' or inputString[i] == 'j':
        if inputString[i] == '-':
            if inputString[i-1] == 'd' or inputString[i-1] == 'c':
                count -= 1
        elif inputString[i] == '=':
            if inputString[i-1] == 'z' or inputString[i-1] == 'c' or inputString[i-1] == 's':
                if inputString[i-1] == 'z':
                    if i-2 >= 0 and inputString[i-2] == 'd':
                        count -= 2
                    else:
                        count -= 1
                else:
                    count -= 1
        else:
            if i-1 >= 0 and inputString[i-1] == 'n' or inputString[i-1] == 'l':
                count -= 1
print(count)
