def check_nps(candidate: str):
    ps_counter = 0
    for char in candidate:
        if char == '(':
            ps_counter += 1
        elif char == ')':
            if ps_counter == 0:
                return False
            else:
                ps_counter -= 1
        else:
            return False
    return ps_counter == 0

results = list()
for _ in range(int(input())):
    result = check_nps(input())
    if result:
        results.append("YES")
    else:
        results.append("NO")


print("\n".join(results))
