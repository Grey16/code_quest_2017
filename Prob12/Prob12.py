def main():
    with open("Prob12.in.txt") as f:
        myList = [line.rstrip('\n') for line in f]
        n = int(myList[0])
        index = 1
        for i in range(1, n + 1):
            m = int(myList[index])
            index += 1
            dailyBalance = 0
            balance = 0
            for j in range(m):
                temp = ""
                currIn = list(myList[index])
                startIndex = len(str(j)) + 1
                for k in range(startIndex, len(currIn)):
                    if(currIn[k] == ','):
                        if(len(temp) != 0):
                            dailyBalance += float(temp)
                            temp = ""
                    else:
                        temp += currIn[k]
                if len(temp) != 0:
                    dailyBalance -= float(temp)
                balance += dailyBalance
                index += 1
            output = (balance / m) * (0.18 / 12)
            print("$" +"{0:.2f}".format(output))

if __name__ == "__main__": main()
