counter = {'0': 0, '1': 0}
string = input()

counter[string[0]] += 1

for index in range(1, len(string)):
    if string[index - 1] != string[index]:
        counter[string[index]] += 1

print(min(counter.values()))
    
