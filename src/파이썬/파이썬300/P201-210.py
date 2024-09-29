# 201
def print_coin():
    print("비트코인")

# 202
print_coin()

# 203
for i in range(100):
    print_coin()

# 204
def print_coins():
    print("비토코인"*100)
print_coins()

# 205
# hello() // 함수 정의 이전에 호출되었기 떄문에
def hello():
    print("Hi")

# 206 //  A B C A B
def message() :
    print("A")
    print("B")

message()
print("C")
message()

# 207 // A C B
print("A")

def message() :
    print("B")

print("C")
message()

# 208 // A C B E D
print("A")
def message1() :
    print("B")
print("C")
def message2() :
    print("D")
message1()
print("E")
message2()

# 209 // B A
def message1():
    print("A")

def message2():
    print("B")
    message1()

# 210 // B C B C B C A
def message1():
    print("A")

def message2():
    print("B")

def message3():
    for i in range (3) :
        message2()
        print("C")
    message1()

message3()


