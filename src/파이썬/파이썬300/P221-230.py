# 221
import math

def print_reverse(string: str) :
    print(string[::-1])
print_reverse("python")

# 222
def print_score(score_list: list) :
    print(sum(score_list)/len(score_list))
print_score ([1, 2, 3])

# 223
def print_even(numbers: list) :
    print(list(filter(lambda x: x % 2 == 0, numbers)))
print_even ([1, 3, 2, 10, 12, 11, 15])

# 224
def print_keys (dictionary: dict):
    print(list(dictionary.keys()))
print_keys ({"이름":"김말똥", "나이":30, "성별":0})

# 225
my_dict = {"10/26" : [100, 130, 100, 100],
           "10/27" : [10, 12, 10, 11]}
def print_value_by_key (dictionary: dict, key: str):
    print(dictionary[key])
print_value_by_key  (my_dict, "10/26")

# 226
def print_5xn(string: str):
    for i in range(len(string) // 5 + 1):
        print(string[i*5:i*5+5])
print_5xn("아이엠어보이유알어걸")

# 227
def print_mxn(string: str, num: int):
    for i in range(len(string) // num + 1):
        print(string[i*num:i*num+num])
print_mxn("아이엠어보이유알어걸", 3)


# 228
def calc_monthly_salary(annual_salary: int):
    print(math.trunc(annual_salary / 12))
calc_monthly_salary(12000000)

# 229
def my_print(a,b) :
    print(f"왼쪽 {a}")
    print(f"오른쪽 {b}")
my_print(a=100, b=200)


# 230
def my_print (a, b) :
    print("왼쪽:", a)
    print("오른쪽:", b)

my_print(b=100, a=200)