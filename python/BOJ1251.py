word:str = input()
length:str = len(word)
candidates=[]

p1:int = 0
p2:int = 0

for p1 in range(1,length-1):
    for p2 in range(p1+1,length):
        token1 = word[0:p1][::-1]
        token2 = word[p1:p2][::-1]
        token3 = word[p2:length][::-1]
        
        candidates.append(token1+token2+token3)
        

print(sorted(candidates)[0])
    