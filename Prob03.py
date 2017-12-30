def main():
    with open("Prob03.in.txt") as f:
        myList = [line.rstrip('\n') for line in f]
        n = int(myList[0])
        for i in range(1, n + 1):
            parts = myList[i].split()
            num1 = int(parts[0])
            num2 = int(parts[1])
            print((num1 + num2), end = "")
            print(" ", end = "")
            print(num1 * num2)


if __name__ == "__main__": main()
