N: int = int(input())
answer:int = 0
count:int  = 666
target:str = "666"


while N > 0:
    if str(count).__contains__(target):
        N -= 1
        answer = count
    count += 1
    
print(answer)