# 151
리스트 = [3, -20, -3, 44]
for num in filter(lambda x : x < 0, 리스트):
    print(num)

# 152
리스트 = [3, 100, 23, 44]
for num in filter(lambda  x : x % 3 == 0 , 리스트):
    print(num)

# 153
리스트 = [13, 21, 12, 14, 30, 18]
for num in filter(lambda  x : x % 3 == 0 and x < 20 ,리스트):
    print(num)

# 154
리스트 = ["I", "study", "python", "language", "!"]
for char in filter(lambda x : len(x) > 3 , 리스트):
    print(char)

# 155
리스트 = ["A", "b", "c", "D"]
for char in filter(lambda x : x.isupper(), 리스트):
    print(char)

# 156
리스트 = ["A", "b", "c", "D"]
for char in filter(lambda  x : x.islower(),리스트):
    print(char)

# 157
리스트 = ['dog', 'cat', 'parrot']
for animal in 리스트:
    print(animal.capitalize())

# 158
리스트 = ['hello.py', 'ex01.py', 'intro.hwp']
for file in 리스트:
    print(file.split(".")[0])

# 159
리스트 = ['intra.h', 'intra.c', 'define.h', 'run.py']
for file in filter(lambda  x: x.split(".")[1] == "h", 리스트):
    print(file)

# 160
리스트 = ['intra.h', 'intra.c', 'define.h', 'run.py']
for file in filter(lambda x: x.split(".")[1] in ["h","c"],리스트):
    print(file)
