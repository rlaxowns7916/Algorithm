sugar = int(input())
count=0

while sugar > 0:
    if sugar % 5 == 0:
       count += sugar // 5
       sugar %= 5 
    else:
        count += 1
        sugar -= 3
        
print(-1 if sugar < 0 else count)
    