def is_valid(string: str) -> bool :  
    stack = []
    for chr in string:
        if chr == '(':
            stack.append(chr)
        else:
            if not stack:
                return False
            else:
                stack.pop()
    if not stack:
        return True
    else:
        return False


T = int(input())
answer= []
for i in range(T):
    answer.append("YES" if is_valid(input()) else "NO")
print("\n".join(answer))

