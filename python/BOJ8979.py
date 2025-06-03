N, K = map(int, input().split())

class MedalContext:
    def __init__(self, index: int, gold: int, silver: int, bronze: int):
        self.index = index
        self.gold = gold
        self.silver = silver
        self.bronze = bronze
        
    def __lt__(self, other: "MedalContext") -> bool:
        if self.gold != other.gold:
            return self.gold > other.gold 
        elif self.silver != other.silver:
            return self.silver > other.silver  
        else:
            return self.bronze > other.bronze  
    
    def __eq__(self, other: "MedalContext") -> bool:
        return (self.gold == other.gold and 
                self.silver == other.silver and 
                self.bronze == other.bronze)

countries = []

for _ in range(N):
    inputs = input().split()
    index = int(inputs[0])
    gold = int(inputs[1])
    silver = int(inputs[2])
    bronze = int(inputs[3])
    
    countries.append(MedalContext(index, gold, silver, bronze))


target_country = None
for country in countries:
    if country.index == K:
        target_country = country
        break

rank = 1
for country in countries:
    if country < target_country:
        rank += 1

print(rank)