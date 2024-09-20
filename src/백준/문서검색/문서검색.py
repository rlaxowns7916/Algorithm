text = input()
pattern = input()

text = text.replace(pattern,"*")
print(text.count("*"))