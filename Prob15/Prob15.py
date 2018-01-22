def main():
    with open("Prob15.in.txt") as f:
        inputList = [line.rstrip('\n') for line in f]
        numTestCases = int(inputList[0])

        for i in range(1, numTestCases + 1):
            currInput = list(inputList[i])
            # empty list to keep track of the number of each type of card
            numCards = [0] * 9
            mostOfAKind = 0
            theKind = 0
            for j in range(len(currInput)):
                card = int(currInput[j])
                if card != 0:
                    numCards[card - 1] += 1
                    if numCards[card - 1] > mostOfAKind:
                        mostOfAKind = numCards[card - 1]
                        theKind = card - 1

            message = None

            if mostOfAKind >= 5:
                message = " = FIVE OF A KIND"
            elif mostOfAKind == 4:
                message = " = FOUR OF A KIND"

            if message == None and mostOfAKind == 3:
                fullHouse = False
                for j in range(len(numCards)):
                    if j != theKind and numCards[j] >= 2:
                        fullHouse = True
                        break
                if fullHouse:
                    message = " = FULL HOUSE"

            if message == None:
                longestRun = 0
                currRun = 0
                for j in range(len(numCards)):
                    if numCards[j] > 0:
                        currRun += 1
                    else:
                        if currRun > longestRun:
                            longestRun = currRun
                        currRun = 0
                if currRun > longestRun:
                    longestRun = currRun
                if longestRun >= 5:
                    message = " = STRAIGHT"

            if message == None and mostOfAKind == 3:
                message = " = THREE OF A KIND"

            if message == None and mostOfAKind == 2:
                twoPair = False
                for j in range(len(numCards)):
                    if j != theKind and numCards[j] == 2:
                        twoPair = True
                        break
                if twoPair:
                    message = " = TWO PAIR"
                else:
                    message = " = PAIR"

            if message == None:
                greatestValue = 0
                for j in range(len(numCards) - 1, -1, -1):
                    if numCards[j] > 0:
                        greatestValue = j + 1
                        break
                message = " = " + str(greatestValue)

            print(inputList[i] + message)

if __name__ == "__main__": main()
