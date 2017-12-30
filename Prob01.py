def main():
    with open("Prob01.in.txt") as f:
        myList = [line.rstrip('\n') for line in f]
        n = int(myList[0])
        for i in range (1, n + 1):
            print(myList[i])
            print(myList[i])
    f.close()

if __name__ == "__main__": main()
