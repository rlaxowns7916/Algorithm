import requests

# 121
char = input()
if 'a' <= char <= 'z':
    print(char.upper())
elif 'A' <= char <= 'Z':
    print(char.lower())
else:
    print("Wrong input")

# 122
score = input("score: ")
score = int(score)
if 81 <= score <= 100:
    print("grade is A")
elif 61 <= score <= 80:
    print("grade is B")
elif 41 <= score <= 60:
    print("grade is C")
elif 21 <= score <= 40:
    print("grade is D")
else:
    print("grade is E")

# 123
exchange_rates = {"달러": 1167, "엔": 1.096, "유로": 1268, "위안": 171}
user_input = input("입력: ").strip().split(" ")
amount = int(user_input[0])
currency = user_input[1]

if currency in exchange_rates.keys():
    rate = exchange_rates[currency]
    print((float(amount * rate)))

# 124
print(max(max(input("input number1"),input("input number2")),input("input number3")))

# 125
telecoms = {"011": "SKT", "016": "KT", "019": "LGU", "010": "알수없음"}
phone_number_prefix = input("휴대전화 번호 입력: ").split("-")[0]

if phone_number_prefix in telecoms.keys():
    print(f"당신은 {telecoms[phone_number_prefix]} 사용자입니다.")
else:
    print("알수없음")

# 126
post_number_prefix = {"010": "강북구", "011": "강북구", "012": "강북구", "013": "도봉구", "014": "도봉구",
                      "015": "도봉구", "016": "노원구", "017": "노원구", "018": "노원구", "019": "노원구"}
post_numbers = input("우편번호: ")

if post_numbers[:3] in post_number_prefix.keys():
    print(f"당신은 {post_number_prefix[post_numbers[:3]]}에 거주합니다.")

# 127
user_identification_number = input("주민등록번호: ")
gender_flag = user_identification_number.split("-")[1][0]

if gender_flag in ("1","3"):
    print("남자")
else:
    print("여자")

# 128
user_identification_number = input("주민등록번호: ")
resident_identification_number = int(user_identification_number.split("-")[1][1:3])

if resident_identification_number in range(0,9):
    print("서울입니다.")
elif resident_identification_number in range(9,13):
    print("부산입니다.")
else:
    print("Wrong input")

# 129
user_identification_number = input("주민등록번호: ").replace("-","").strip()
user_check_sum = int(user_identification_number[-1])

check_sum_salt = 0
check_sum = 0

for index in range(0,12):
    check_sum += int(user_identification_number[index]) * (check_sum_salt % 8 + 2)
    check_sum_salt += 1
check_sum = 11 - (check_sum % 11)


if check_sum == user_check_sum:
    print("유효한 주민등록번호입니다.")
else:
    print("유효하지 않은 주민등록번호입니다.")

# 130

btc = requests.get("https://api.bithumb.com/public/ticker/").json()['data']
prices_gap  = btc['max_price'] - btc['min_price']

if btc['opening_price'] + prices_gap > btc['max_price']:
    print("상승장")
else:
    print("하락장")
