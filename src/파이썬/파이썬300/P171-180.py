# 171
prices_list = [32100, 32150, 32000, 32500]
for price in prices_list:
    print(price)

# 172
prices_list = [32100, 32150, 32000, 32500]
for index,price in enumerate(prices_list):
    print(f"{index} {price}")

# 173
prices_list = [32100, 32150, 32000, 32500]
for index,price in enumerate(reversed(prices_list)):
    print(f"{(len(prices_list)-1) - index} {price}")

# 174
price_list = [32100, 32150, 32000, 32500]
for index in range(1,len(price_list)):
    print(90 + 10*index, price_list[index])

# 175
my_list = ["가", "나", "다", "라"]
for i in range(len(my_list)-1):
        print(my_list[i],my_list[i+1])

# 176
my_list = ["가", "나", "다", "라", "마"]
for i in range(len(my_list)-2):
    print(my_list[i],my_list[i+1],my_list[i+2])

# 177
my_list = ["가", "나", "다", "라"]
for i in range(len(my_list)-1,0,-1):
    print(my_list[i],my_list[i-1])

# 178
my_list = [100, 200, 400, 800]
for i in range(len(my_list)-1):
    print(my_list[i+1] - my_list[i])

# 179
my_list = [100, 200, 400, 800, 1000, 1300]
for i in range(len(my_list)-3):
    print((my_list[i] + my_list[i+1] + my_list[i+2])/3)

# 180
volatility = []
low_prices  = [100, 200, 400, 800, 1000]
high_prices = [150, 300, 430, 880, 1000]

for index in range(len(low_prices)):
    volatility.append(high_prices[index] - low_prices[index])
print(volatility)