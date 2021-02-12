inputString = input().upper()
maxNum = 0
flag = False
alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
index = ""

for i in range(len(alphabet)):
    num = inputString.count(alphabet[i])
    if maxNum == num:
        flag = True
    elif num > maxNum:
        maxNum = num
        flag = False
        index = alphabet[i]

if flag:
    print("?")
else:
    print(index)
