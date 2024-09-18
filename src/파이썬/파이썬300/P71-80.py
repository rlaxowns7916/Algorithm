# 71
my_variable = ()
print(type(my_variable))
# 72
movie_rank = ("닥터 스트레인지", "스플릿", "럭키")
print(type(movie_rank))

# 73
my_tuple = (1,)
print(type(my_tuple))

# 74
t = (1,2,3)
# t[0] = 'a'
# TypeError: 'tuple' object does not support item assignment --> Tuple은 Immutable하다.

# 75
t = 1,2,3,4
print(type(t))

# 76
t = ('a','b','c')
t = ('A','b','c')
# Tuple은 Immutable하기 때문에 새롭게 인스턴스를 만드는 방법 밖에는 없다.

# 77
interest = ('삼성전자', 'LG전자', 'SK Hynix')
interest = list(interest)
print(type(interest))

# 78
interest = ['삼성전자', 'LG전자', 'SK Hynix']
interest = tuple(interest)
print(type(interest))

# 79
temp = ('apple', 'banana', 'cake')
a, b, c = temp
print(a,b,c)

# 80
data = tuple(range(2,100,2))
print(data)