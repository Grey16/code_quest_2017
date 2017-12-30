def main():
    with open("Prob05.in.txt") as f:
        myList = [line.rstrip('\n') for line in f]
        n = int(myList[0])

        for i in range(1, n + 1):
            lastYear = myList[2 * i - 1].split(",")
            thisYear = myList[2 * i].split(",")

            lastYear.sort()
            thisYear.sort()

            onlyLast = []
            onlyThis = []
            both = []

            for j in range(len(lastYear)):
                if lastYear[j] in thisYear:
                    both.append(lastYear[j])
                else:
                    onlyLast.append(lastYear[j])

            for j in range(len(thisYear)):
                if thisYear[j] not in lastYear:
                    onlyThis.append(thisYear[j])

            print(",".join(onlyLast))
            print(",".join(both))
            print(",".join(onlyThis))

if __name__ == "__main__": main()
