operands = list()
operators = list()
equation = list()

operandsUsed = list()
operatorsUsed = list()

targetResult = 0

solutionFound = False

ADDITION = "+"
SUBTRACTION = "-"
MULTIPLICATION = "*"
DIVISION = "/"

def main():
    with open("Prob16.in.txt") as f:
        inputList = [line.rstrip('\n') for line in f]
        numTestCases = int(inputList[0])
        for i in range(1, numTestCases + 1):
            currInput = inputList[i].split(":")
            global targetResult
            targetResult = int(currInput[0])

            symbols = currInput[1].split(" ")
            numOperands = int((len(symbols) / 2) + 1)
            numOperators = numOperands - 1
            global operands
            operands = [None] * numOperands
            global operators
            operators = [None] * numOperators

            operandIndex = 0
            operatorIndex = 0
            for j in range(len(symbols)):
                try:
                    int(symbols[j])
                    operands[operandIndex] = symbols[j]
                    operandIndex += 1
                except ValueError:
                    operators[operatorIndex] = symbols[j]
                    operatorIndex += 1

            global operandsUsed
            operandsUsed = [False] * numOperands
            global operatorsUsed
            operatorsUsed = [False] * numOperators

            global solutionFound
            solutionFound = False
            equation = [None] * (numOperands + numOperators)

            #fillEquation(0)

def fillEquation(currentPosition):
    #fillEquation

def solveEquation(equation):
    currentIndex = 0
    while currentIndex < len(equation):
        currentSymbol = equation[currentIndex]
        if currentSymbol == MULTIPLICATION or currentSymbol == DIVISION:





if __name__ == "__main__": main()
