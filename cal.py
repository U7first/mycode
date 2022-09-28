import random
try:
    total = int(input("输入题数："))
except ValueError:
    print("请输入正确的数量！")
else:
    n = 0
    list1 = []
    list2 = []
    while n<total:
        degree = random.randint(1,2)
        f = "+-"
        f1 = random.choice(f)
        if degree == 1:
            if f1 == "+":
                a = random.randint(0,99)
                b = random.randint(0,99-a)
                s = str(n+1)+".  "+str(a)+f1+str(b)+"="
                result = str(n+1)+".  "+str(a+b)
                if (s not in list1):
                    list1.append(s)
                    list2.append(result)
                else:
                    n -= 1
            else:
                a = random.randint(0,99)
                b = random.randint(0,a)
                s = str(n+1)+".  "+str(a)+f1+str(b)+"="
                result = str(n+1)+".  "+str(a-b)
                if (s not in list1):
                    list1.append(s)
                    list2.append(result)
                else:
                    n -= 1
        else:
            f2 = random.choice(f)
            if (f1 == "+")and(f2 == "+"):
                a = random.randint(0,99)
                b = random.randint(0,99-a)
                c = random.randint(0,99-a-b)
                s = str(n+1)+".  "+str(a)+f1+str(b)+f2+str(c)+"="
                result = str(n+1)+".  "+str(a+b+c)
                if (s not in list1):
                    list1.append(s)
                    list2.append(result)
                else:
                    n -= 1
            elif (f1 == "+")and(f2 == "-"):
                a = random.randint(0,99)
                b = random.randint(0,99-a)
                c = random.randint(0,a+b)
                s = str(n+1)+".  "+str(a)+f1+str(b)+f2+str(c)+"="
                result = str(n+1)+".  "+str(a+b-c)
                if (s not in list1):
                    list1.append(s)
                    list2.append(result)
                else:
                    n -= 1
            elif (f1 == "-")and(f2 == "+"):
                a = random.randint(0,99)
                b = random.randint(0,a)
                c = random.randint(0,100-a+b)
                s = str(n+1)+".  "+str(a)+f1+str(b)+f2+str(c)+"="
                result = str(n+1)+".  "+str(a-b+c)
                if (s not in list1):
                    list1.append(s)
                    list2.append(result)
                else:
                    n -= 1
            else:
                a = random.randint(0,99)
                b = random.randint(0,a)
                c = random.randint(0,a-b)
                s = str(n+1)+".  "+str(a)+f1+str(b)+f2+str(c)+"="
                result =str(n+1)+".  "+str(a-b-c)
                if (s not in list1):
                    list1.append(s)
                    list2.append(result)
                else:
                    n -= 1
        n += 1
    print(*list1,sep = "\n",file = open("Exercises.txt","w"))
    print(*list2,sep = "\n",file = open("Answers.txt","w"))