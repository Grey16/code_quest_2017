def main():
    with open("Prob07.in.txt") as f:
        myList = [line.rstrip('\n') for line in f]
        n = int(myList[0])
        for i in range(1, n + 1):
            inputs = myList[i].split(":")
            data = inputs[1].split(",")
            hits = [0, 0, 0, 0]
            atBats = 0
            for j in data:
                if j != "BB":
                    atBats += 1
                    if j == "1B":
                        hits[0] += 1
                    elif j == "2B":
                        hits[1] += 1
                    elif j == "3B":
                        hits[2] += 1
                    elif j == "HR":
                        hits[3] += 1

            if atBats == 0:
                print(inputs[0] + "=" + "0.000")
            else:
                slg = float((1 * hits[0]) + (2 * hits[1]) + (3 * hits[2]) + (4 * hits[3])) / atBats
                print(inputs[0] + "=" + "{0:.3f}".format(slg))

if __name__ == "__main__": main()
