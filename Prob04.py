def main():
    with open("Prob04.in.txt") as f:
        myList = [line.rstrip('\n') for line in f]
        n = int(myList[0])

        for i in range(1, n + 1):
            print(str(myList[i]) + " = " + str(fibonacci(int(myList[i]))))

def fibonacci(num):
    fib = [0, 1]
    if num == 1:
        return 0
    elif num == 2:
        return 1
    else:
        for i in range(num - 2):
            temp = fib[1]
            fib[1] += fib[0]
            fib[0] = temp
        return fib[1]


if __name__ == "__main__": main()
