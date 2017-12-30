def main():
    with open("Prob02.in.txt") as f:
        myList = [line.rstrip('\n') for line in f]
        n = int(myList[0])

        currLine = None
        for i in range(1, n + 1):
            currLine = myList[i].split()
            word = currLine[0]
            letter = int(currLine[1])
            for j in range(len(word)):
                if j != letter:
                    print(word[j], end = "")
            print("")

if __name__ == "__main__": main()
