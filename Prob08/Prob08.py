def main():
    with open("Prob08.in.txt") as f:
        myList = [line.rstrip('\n') for line in f]
        n = int(myList[0])
        for i in range(1, n + 1):
            inputs = myList[i].split(" ")
            current = (float(inputs[0]) * 1000000) / float(inputs[1])
            days = int(current / 24)
            current %= 24
            hours = int(current)
            current %= 1
            current *= 60
            minutes = int(current)
            current %= 1
            current *= 60
            seconds = int(round(current, 0))

            if seconds == 60:
                seconds = 0
                minutes += 1
            if minutes == 60:
                minutes = 0
                hours += 1
            if hours == 24:
                hours = 0
                days += 1

            print("Time to Mars: " + str(days) + " days, " + str(hours) + " hours, " + str(minutes) + " minutes, " + str(seconds) + " seconds")

if __name__ == "__main__": main()
