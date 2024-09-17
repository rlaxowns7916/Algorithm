# 31 (34)
a = "3"
b = "4"
print(a+b)

# 32 (HIHIHI)
print("HI" * 3)

# 33
print("-"*80)

# 34
t1 = "python"
t2 = "java"
print(f"{t1} {t2} " * 4)

# 35 (string %)
name1 = "김민수"
age1 = 10
name2 = "이철희"
age2 = 13

print("이름: %s 나이: %d" % (name1,age1))
print("이름: %s 나이: %d" % (name2,age2))

# 36 (string.format)
name1 = "김민수"
age1 = 10
name2 = "이철희"
age2 = 13
print("이름: {} 나이: {}".format(name1, age1))
print("이름: {} 나이: {}".format(name2, age2))

# 37 (fstring)
name1 = "김민수"
age1 = 10
name2 = "이철희"
age2 = 13

print(f"이름: {name1} 나이: {age1}")
print(f"이름: {name2} 나이: {age2}")


# 38
상장주식수 = "5,969,782,550"
print(type(int(상장주식수.replace(",",""))))

# 39 (slicing)
분기 = "2020/03(E) (IFRS연결)"
print(분기.split("(")[0])

# 40 (string)
data = "    삼성전자    "
print(data.strip())