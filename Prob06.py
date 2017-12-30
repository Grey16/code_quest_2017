def main():
    alpha = ("Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India", "Juliet", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango", "Uniform", "Victor", "Whiskey", "Xray", "Yankee", "Zulu")
    with open("Prob06.in.txt") as f:
        myList = [line.rstrip('\n') for line in f]
        n = int(myList[0])
        index = 1
        for i in range(n):
            m = int(myList[index])
            index += 1
            for j in range(m):
                myList[index] = myList[index].upper()
                for k in range(len(myList[index])):
                    c = ord(myList[index][k])
                    if c != 32:
                        print(alpha[c - 65], end = "")
                        if (k + 1) < len(myList[index]) and ord(myList[index][k + 1]) != 32:
                            print("-", end = "")
                    else:
                        print(" ", end = "")
                print()
                index += 1

if __name__ == "__main__": main()
