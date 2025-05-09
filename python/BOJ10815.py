N: int = int(input())
cards: dict[int, int] = dict(map(lambda x: (int(x), int(x)),input().split(" "))) 

M: int = int(input())
need_to_check: list[int] = map(lambda x: int(x), input().split(" "))


answer = []
for element in need_to_check : 
    if cards.get(element, 0) != 0:
        answer.append("1")
    else:
        answer.append("0")

print(" ".join(answer))