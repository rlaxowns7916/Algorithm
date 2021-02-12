inputString = input()
alphabet = "abcdefghijklmnopqrstuvwxyz"

for i in range(len(alphabet)):
    print(inputString.find(alphabet[i]), end=" ")
