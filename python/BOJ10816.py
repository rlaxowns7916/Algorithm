N:int  = int(input())
cards: list[int] = list(map(int, input().split(" ")))

M: int = int(input())
questions: list[int] = list(map(int, input().split(" ")))

card_counter:dict[int,int] = {}
for card in cards:
    card_counter[card]= card_counter.get(card,0)+1
    
    
answer:list[str] =[]
for question in questions:
    answer.append(str(card_counter.get(question,0)))
    
  
print(" ".join(answer))