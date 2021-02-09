while True:
    try:
        num1, num2 = map(int, input().split())
        print("%d" % (num1+num2))
    except:
        break
