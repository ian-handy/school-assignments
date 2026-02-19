# This program will ask the user to input three numbers and output to the screen the largest of the three numbers entered.

def number_comparison():
    print("Enter three numbers and I will tell you which one is greatest.")
    number1 = float(input("Please enter the first number:"))
    number2 = float(input("Please enter the second number:"))
    number3 = float(input("Please enter the third number:"))
    return f'{max([number1,number2,number3])} is the greatest of these numbers.'
print(number_comparison())