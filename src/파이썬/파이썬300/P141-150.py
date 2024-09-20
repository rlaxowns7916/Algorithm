# 141
리스트 = [100, 200, 300]
for i in 리스트:
    print(10 + i)

# 142
리스트 = ["김밥", "라면", "튀김"]
for 음식 in 리스트:
    print(f"오늘의 메뉴: {음식}")

# 143
리스트 = ["SK하이닉스", "삼성전자", "LG전자"]
for stock in 리스트:
    print(len(stock))

# 144
리스트 = ['dog', 'cat', 'parrot']

for animal in 리스트:
    print(animal, len(animal))

# 145
리스트 = ['dog', 'cat', 'parrot']
for animal in 리스트:
    print(animal[0])

# 146
리스트 = [1, 2, 3]
for num in 리스트:
    print(f"3 X {num}")

# 147
리스트 = [1, 2, 3]
for num in 리스트:
    print(f"3 X {num} = {3*num}")

# 148
리스트 = ["가", "나", "다", "라"]
for idx in range(1, len(리스트)):
    print(리스트[idx])

# 149
리스트 = ["가", "나", "다", "라"]
for idx in range(0, len(리스트)-1,2):
    print(리스트[idx])

# 150
리스트 = ["가", "나", "다", "라"]
for char in 리스트[::-1]:
    print(char)