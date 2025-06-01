T: int = int(input())
answer=[]

for turn in range(T):
    clothes:dict[str,set[str]] = {}
    N:int = int(input())
    
    result= 1
    for i in range(N):
        (name, type) = input().split(" ")
        names = clothes.get(type,set())
        names.add(name)

        clothes[type] = names
        
    for names in clothes.values():
        result *= (len(names)+1)
        print(names)  

    answer.append(result-1)
    
print("\n".join(map(str,answer)))