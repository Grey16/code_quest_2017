def main():
    HIGH = 0.9 * (1000.0 / 90)
    EXTRAPOLATE = 0.85 * (1000.0 / 90)
    LOW = 0.7 * (1000.0 / 90)

    with open("Prob13.in.txt") as f:
        myList = [line.rstrip('\n') for line in f]

        n = int(myList[0])
        for i in range(1, n + 1):
            currInput = myList[i].split(" ")
            data = []
            for j in range(len(currInput)):
                data.append(float(currInput[j]))

            quality = int(data[3])
            if data[2] > HIGH:
                quality -= 2
            elif data[2] > EXTRAPOLATE:
                extrap1 = data[2] + ((data[2] - data[0]) / 2)
                extrap2 = data[2] + (data[2] - data[1])
                if extrap1 > HIGH or extrap2 > HIGH:
                    quality -= 2
            elif data[0] < LOW and data[1] < LOW and data[2] < LOW:
                quality += 1

            print(quality)

if __name__ == "__main__": main()
