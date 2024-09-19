# 101
bool

# 102
print(3==5) # False

# 103
print (3<5) # True

# 104
x = 4
print(1 < x < 5) # True

# 105
print ((3 == 3) and (4 != 3)) # True

# 106
# print(3 => 4) --> >=로 바꾸어야함

# 107 # Unreachable code
if 4 < 3:
    print("Hello World")

# 108 Hi there.
if 4 < 3:
    print("Hello World.")
else:
    print("Hi, there.")


# 109 (1,2,4)
if True :
    print ("1")
    print ("2")
else :
    print("3")
print("4")


# 110 (3,5)
if True :
    if False:
        print("1")
        print("2")
    else:
        print("3")
else :
    print("4")
print("5")