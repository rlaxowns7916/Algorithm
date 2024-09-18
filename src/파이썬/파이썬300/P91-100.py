# 91
from asyncore import close_all

inventory = {"메로나": [300, 20], "비비빅": [400, 3], "죠스바": [250, 100]}
print(inventory)

# 92
inventory = {"메로나": [300, 20], "비비빅": [400, 3], "죠스바": [250, 100]}
amount = inventory["메로나"][0]
print(f"{amount}원")

# 93
inventory = {"메로나": [300, 20], "비비빅": [400, 3], "죠스바": [250, 100]}
count = inventory["메로나"][1]
print(f"{count}개")

# 94
inventory = {"메로나": [300, 20], "비비빅": [400, 3], "죠스바": [250, 100]}
inventory["월드콘"] = [500, 7]
print(inventory)

# 95
ice_cream = {"탱크보이": 1200, "폴라포": 1200, "빵빠레": 1800, "월드콘": 1500, "메로나": 1000}
ice_cream_keys = list(ice_cream.keys())
print(ice_cream_keys)

# 96
ice_cream = {"탱크보이": 1200, "폴라포": 1200, "빵빠레": 1800, "월드콘": 1500, "메로나": 1000}
ice_cream_values = list(ice_cream.values())
print(ice_cream_values)

# 97
ice_cream = {"탱크보이": 1200, "폴라포": 1200, "빵빠레": 1800, "월드콘": 1500, "메로나": 1000}
print(sum(ice_cream.values()))

# 98
ice_cream = {"탱크보이": 1200, "폴라포": 1200, "빵빠레": 1800, "월드콘": 1500, "메로나": 1000}
new_product = {"팥빙수": 2700, "아맛나": 1000}
ice_cream.update(new_product)
print(ice_cream)

# 99
# zip은 두개의 Iterable한 객체를 받아서, 하나의 Tuple로 묶어주는 함수이다.
# 길이가 짧은 것이 기준이된다.
keys = ("apple", "pear", "peach")
values = (300, 250, 400)
result = dict(zip(keys,values))
print(result)

# 100
date = ['09/05', '09/06', '09/07', '09/08', '09/09']
close_price = [10500, 10300, 10100, 10800, 11000]
close_table = dict(zip(date,close_price))
print(close_table)