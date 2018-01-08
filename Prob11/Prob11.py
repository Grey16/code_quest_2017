def main():
    with open("Prob11.in.txt") as f:
        myList = [line.rstrip('\n') for line in f]
        n = int(myList[0])
        for i in range(1, n + 1):
            currIn = myList[i]
            word = ""
            for j in currIn:
                if ord(j) > 64 and ord(j) < 91 or ord(j) > 96 and ord(j) < 123:
                    word += j
                else:
                    if word != "":
                        reverse(word)
                    word = ""
                    print(j, end = "")
            if word != "":
                reverse(word)
            print()

def reverse(word):
    letters = list(word)
    for i in range(len(letters)):
        j = len(letters) - i - 1
        if j <= i:
            break
        else:
            if letters[i].isupper() == letters[j].isupper():
                c = letters[i]
                letters[i] = letters[j]
                letters[j] = c
            else:
                c = letters[i]
                letters[i] = letters[j]
                letters[j] = c
                if letters[j].isupper():
                    letters[i] = letters[i].upper()
                    letters[j] = letters[j].lower()
                else:
                    letters[i] = letters[i].lower()
                    letters[j] = letters[j].upper()
    print("".join(letters), end = "")

if __name__ == "__main__": main()
