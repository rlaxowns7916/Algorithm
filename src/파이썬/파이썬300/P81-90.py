# 81 (Unpacking Operator)

a,b,*c = (0,1,2,3,4,5)
print(f"a: {a}, b: {b}, c: {c}")

# 82
scores = [8.8, 8.9, 8.7, 9.2, 9.3, 9.7, 9.9, 9.5, 7.8, 9.4]
_,_,*valid_score = scores
print(valid_score)

# 83
_,*valid_score,_ = scores
print(valid_score)

# 84
temp = {}

# 85
ice_creams = {
    "메로나": 1000,
    "폴라포": 1200,
    "빵빠레": 1800
}

# 86
ice_creams["죠스바"] = 1200
ice_creams["월드콘"] = 1500
print(ice_creams)

# 87
print(f"메로나 가격: {ice_creams['메로나']}")

# 88
ice_creams["메로나"] = 1300
print(f"메로나 가격: {ice_creams['메로나']}")

# 89
del ice_creams["메로나"]
print(ice_creams)

# 90
ice_cream = {"폴라포": 1200, "빵빠레": 1800, "월드콘": 1500, "메로나": 1000}
# ice_cream["누가바"] >> KeyError: '누가바' >> Dictionary에 없는 Key를 호출하면 KeyError가 발생한다.