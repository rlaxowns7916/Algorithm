# 21 (index)
letters = "python"
print(letters[0], letters[2])

# 22 (slice)
license_plate = "24가 2210"
print(license_plate[-4:])

# 23 (index)
string = "홀짝홀짝홀짝"
print(string[::2])

# 24 (reverse)
string = "PYTHON"
print(string[::-1])

# 25
phone_number = "010-1111-2222"
print(phone_number.replace("-"," "))

# 26
phone_number = "010-1111-2222"
print(phone_number.replace("-",""))

#27
url = "http://sharebook.kr"
print(url.split(".")[-1])

#28 (문자열은 Immutable)
try:
    lang = "python"
    lang[0] = "P"
    print(lang)
except TypeError:
    print(f"문자열은 Immutable {TypeError}")


# 29 (replace)
string = "abcdfe2a35432a"
print(string.replace("a","A"))

# 30 (replace)
# String은 Immutable이기 때문에, 원본을 복사하고 수정한 수정본을 리턴한다
string = "abcd"
string.replace("b","B")
print(string)