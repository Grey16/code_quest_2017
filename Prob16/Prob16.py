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

def solveEquation(equation):
    currentIndex = 0
    while currentIndex < len(equation):
        currentSymbol = equation[currentIndex]
        if currentSymbol == MULTIPLICATION or currentSymbol == DIVISION:
            firstOperand = equation[currentIndex - 1]
            numerator = int(firstOperand)
            denominator = 1
            while currentSymbol == MULTIPLICATION or currentSymbol == DIVISION:
                del(equation[currentIndex])
                secondOperand = int(equation.pop(currentIndex))
                if currentSymbol == MULTIPLICATION:
                    numerator *= secondOperand
                else:
                    denominator *= secondOperand
                if currentIndex < len(equation):
                    currentSymbol = equation[currentIndex]
                else:
                    break
            if denominator == 0 or (numerator % denominator != 0):
                return
            else:
                result = int(numerator / denominator)
                del(equation[currentIndex - 1])
                equation.insert(currentIndex - 1, str(result))
        else:
            currentIndex += 1

    currentIndex = 0
    while currentIndex < len(equation):
        currentSymbol = equation[currentIndex]
        if currentSymbol == ADDITION or currentSymbol == SUBTRACTION:
            firstOperand = int(equation[currentIndex - 1])
            while currentSymbol == ADDITION or currentSymbol == SUBTRACTION:
                del(equation[currentIndex])
                secondOperand = int(equation.pop(currentIndex))
                if currentSymbol == ADDITION:
                    firstOperand += secondOperand
                else:
                    firstOperand -= secondOperand
                if currentIndex < len(equation):
                    currentSymbol = equation[currentIndex]
                else:
                    break
            del(equation[currentIndex - 1])
            equation.insert(currentIndex - 1, str(firstOperand))
        else:
            currentIndex += 1

    if int(equation.pop()) == targetResult:
        global solutionFound
        solutionFound = True


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
            myList = ["8", "*", "4", "+", "4", "/", "4"]
            solveEquation(myList)

            #fillEquation(0)

if __name__ == "__main__": main()
