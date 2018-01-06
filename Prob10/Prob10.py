def main():
    original = ("Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M", ",", ".")
    with open("Prob10.in.txt") as f:
        myList = [line.rstrip('\n') for line in f]
        n = int(myList[0])
        index = 1
        for i in range(n):
            m = int(myList[index])
            index += 1
            capsLock = False
            for j in range(m):
                currIn = myList[index]
                for k in range(len(myList[index])):
                    if currIn[k].upper() == "Q":
                        print("    ", end = "")
                    elif currIn[k].upper() == "A":
                        capsLock = not capsLock
                    elif currIn[k].upper() == "Z":
                        print("", end = "")
                    elif currIn[k] == " ":
                        print(" ", end = "")
                    else:
                        c = ord(currIn[k])
                        if (c > 64 and c < 91) or (c > 96 and c < 123):
                            lowerCase = currIn[k].islower()
                        else:
                            lowerCase = True

                        if (lowerCase and (not capsLock)) or ((not lowerCase) and capsLock):
                            print(original[original.index(currIn[k].upper()) - 1].lower(), end = "")
                        else:
                            print(original[original.index(currIn[k].upper()) - 1], end = "")

                print()
                index += 1

if __name__ == "__main__": main()
