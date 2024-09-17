# 41
ticker = "btc_krw"
print(ticker.upper())

# 42
ticker = "BTC_KRW"
print(ticker.lower())

# 43
string = "hello"
print(string.capitalize())

# 44
file_name = "보고서.xlsx"
print(file_name.endswith("xlsx"))

# 45
file_name = "보고서.xls"
print(file_name.endswith(("xlsx","xls")))

# 46
file_name = "2020_보고서.xlsx"
print(file_name.startswith("2020"))

# 47
a = "hello world"
print(a.split(" "))

# 48
ticker = "btc_krw"
print(ticker.split("_"))

# 49
date = "2020-05-01".split("-")
year = date[0]
month = date[1]
day = date[2]

print(year, month, day)

#50
data = "039490     "
print(data.rstrip())