def main():
    with open("Prob09.in.txt") as f:
        myList = [line.rstrip('\n') for line in f]
        n = int(myList[0])
        for i in range(1, n + 1):
            message = list(myList[2 * i - 1])
            keyword = list(myList[2 * i])
            spaces = 0
            for j in range(len(message)):
                if ord(message[j]) != 32:
                    message[j] = chr((((ord(message[j]) - 65) + (ord(keyword[(j - spaces) % len(keyword)]) - 65)) % 26) + 65);
                else:
                    spaces += 1
            print("".join(message))

if __name__ == "__main__": main()
