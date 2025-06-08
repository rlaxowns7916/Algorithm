document= input()
query= input()
pointer=0
count=0

while pointer < len(document):
    isContain = True
    
    if pointer + len(query) > len(document):
        isContain = False
    else:
        for index in range(len(query)):
            if document[pointer + index] != query[index]:
                isContain = False
    
    if isContain:
        count += 1
        pointer += len(query)
    else:
        pointer += 1

print(count)