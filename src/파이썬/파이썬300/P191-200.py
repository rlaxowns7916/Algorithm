# 191

data = [
    [ 2000,  3050,  2050,  1980],
    [ 7500,  2050,  2050,  1980],
    [15450, 15050, 15550, 14900]
]

for row in data:
    for col in data[0]:
        print(col*1.00014)

# 192
data = [
    [2000, 3050, 2050, 1980],
    [7500, 2050, 2050, 1980],
    [15450, 15050, 15550, 14900]
]

for row in data:
    for col in data[0]:
        print(col * 1.00014)
    print("-"*4)

# 193
data = [
    [2000, 3050, 2050, 1980],
    [7500, 2050, 2050, 1980],
    [15450, 15050, 15550, 14900]
]
result = []

for row in data:
    for col in data[0]:
        result.append(col * 1.00014)
print(result)

# 194
data = [
    [2000, 3050, 2050, 1980],
    [7500, 2050, 2050, 1980],
    [15450, 15050, 15550, 14900]
]
result = []
for row in data:
    sub = []
    for col in row:
        sub.append(col * 1.00014)
    result.append(sub)
print(result)

# 195
ohlc = [["open", "high", "low", "close"],
        [100, 110, 70, 100],
        [200, 210, 180, 190],
        [300, 310, 300, 310]]

search_index = ohlc[0].index("close")
for row in range(1,len(ohlc)):
    print(ohlc[row][search_index])

# 196
ohlc = [["open", "high", "low", "close"],
        [100, 110, 70, 100],
        [200, 210, 180, 190],
        [300, 310, 300, 310]]
search_index = ohlc[0].index("close")

for row in range(1,len(ohlc)):
    close = int(ohlc[row][search_index])
    if close > 150:
        print(close)

# 197

ohlc = [["open", "high", "low", "close"],
        [100, 110, 70, 100],
        [200, 210, 180, 190],
        [300, 310, 300, 310]]

open_index = ohlc[0].index("open")
close_index = ohlc[0].index("close")

for row in range(1,len(ohlc)):
    if ohlc[row][open_index] <= ohlc[row][close_index]:
        print(ohlc[row][close_index])

# 198
ohlc = [["open", "high", "low", "close"],
        [100, 110, 70, 100],
        [200, 210, 180, 190],
        [300, 310, 300, 310]]
high_index = ohlc[0].index("high")
low_index = ohlc[0].index("low")
volatility = []

for row in range(1,len(ohlc)):
    volatility.append(int(ohlc[row][high_index]) - int(ohlc[row][low_index]))
print(volatility)

# 199
ohlc = [["open", "high", "low", "close"],
        [100, 110, 70, 100],
        [200, 210, 180, 190],
        [300, 310, 300, 310]]
open_index = ohlc[0].index("open")
high_index = ohlc[0].index("high")
low_index = ohlc[0].index("low")
close_index = ohlc[0].index("close")

close_higher_ohic = list(filter(lambda x : x[open_index] < x[close_index],ohlc[1:]))

for ohic_data in close_higher_ohic:
    print(ohic_data[high_index] - ohic_data[low_index])

# 200
sum = 0
ohlc = [["open", "high", "low", "close"],
        [100, 110, 70, 100],
        [200, 210, 180, 190],
        [300, 310, 300, 310]]
open_index = ohlc[0].index("open")
high_index = ohlc[0].index("high")
low_index = ohlc[0].index("low")
close_index = ohlc[0].index("close")


for data in ohlc[1:]:
    sum += int(data[close_index]) - int(data[open_index])
print(sum)