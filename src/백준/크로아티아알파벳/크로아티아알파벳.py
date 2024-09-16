croatia_alphabet_prefix=['c', 'd', 'l', 'n', 's', 'z']
croatia_alphabets = {
    'c': ['c=', 'c-'],
    'd': ['dz=', 'd-'],
    'l': ['lj'],
    'n': ['nj'],
    's': ['s='],
    'z': ['z=']
}

pos = 0
count  = 0
target = input()


while pos < len(target):
    if target[pos] in croatia_alphabet_prefix:
        candidates = croatia_alphabets[target[pos]]

        if target[pos:pos+3] in candidates:
            pos += 3
        elif target[pos:pos+2] in candidates:
            pos += 2
        else:
            pos += 1
    else:
        pos += 1
    count += 1

print(count)