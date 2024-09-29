# 211 // 안녕 Hi
def 함수(문자열) :
    print(문자열)

함수("안녕")
함수("Hi")

# 212 // 7, 15
def 함수(a: int, b: int):
    print(a + b)
함수(3,4)
함수(7,8)

# 213
def 함수(문자열: str):
    print(문자열)
# 함수() 파라미터를 전달하지 않아 Error

# 214
def 함수(a, b) :
    print(a + b)

# 함수("안녕", 3) 문자열과 숫자가 타입이 달라 + 연산을 수행 할 수 없다.

# 215
def print_with_smile(string: str) :
    print(string,":D")

# 216
print_with_smile("안녕하세요")

# 217
def print_upper_price(price: int) :
    print(price * 1.3)

# 218
def print_sum(num1: int, num2: int) :
    print(num1+num2)

# 219
def print_arithmetic_operations(num1: int, num2: int) :
    print(num1 + num2)
    print(num1 - num2)
    print(num1 * num2)
    print(num1 / num2)

print_arithmetic_operations(3, 4)

# 220
def print_max(a: int, b: int, c: int) :
    max_value = 0

    if a > max_value :
        max_value = a
    if b > max_value :
        max_value = b
    if c > max_value :
        max_value = c

    print(max_value)
print_max(3,2,1)