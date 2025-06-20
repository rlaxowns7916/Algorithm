def sum_of_numeric(serial:str) -> int:
    sum = 0
    
    for chr in serial:
        if chr.isdigit():
            sum += int(chr)
    return sum


N =  int(input())
guitar_serials = [input() for _ in range(N)]
sorted_guitar_serials = sorted(guitar_serials, key= lambda x: (len(x),sum_of_numeric(x),x))

print("\n".join(sorted_guitar_serials))