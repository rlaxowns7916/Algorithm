# 111
print(input()*2)

# 112
num = int(input("숫자를 입력하세요"))
print(num + 10)

# 113
num = int(input("숫자를 입력하세요"))
if num % 2 == 0:
    print("짝수")
else:
    print("홀수")

# 114
num = int(input("숫자를 입력하세요"))
print(min(num+20,255))

# 115
num = int(input("숫자를 입력하세요"))
print(min(max(num-20,0),255))

# 116
time = input("현재시간:")
if time[-2:] == "00":
    print("정각입니다.")
else:
    print("정각이 아닙니다.")

# 117
fruit = ["사과", "포도", "홍시"]
guess = input("좋아하는 과일은?")
if guess in fruit:
    print("정답입니다.")
else:
    print("오답입니다.")

# 118
warn_investment_list = ["Microsoft", "Google", "Naver", "Kakao", "SAMSUNG", "LG"]
guess = input("투자 종목을 입력하세요:")
if guess in warn_investment_list:
    print("투자 경고 종목입니다.")
else:
    print("투자 경고 종목이 아닙니다.")

# 119
fruit = {"봄" : "딸기", "여름" : "토마토", "가을" : "사과"}
guess = input("제가 좋아하는 계절은:")
if guess in fruit.keys():
    print("정답입니다.")
else:
    print("오답입니다.")

# 120
fruit = {"봄" : "딸기", "여름" : "토마토", "가을" : "사과"}
guess = input("제가 좋아하는 과일은:")
if guess in fruit.values():
    print("정답입니다.")
else:
    print("오답입니다.")

