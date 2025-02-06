#This program will print the name of a member of the cast of The Big Bang Theory based on the following criteria:
# -Print "Sheldon" if a number is divisible by 3.
# -Print "Leonard" if divisible by 5.
# -Print "Raj" if divisible by both 3 and 5.
# -If divisible by 7, print "Howard" instead of the above.
# -If the number contains a digit 7, print “Penny."

def big_bang_number():
    num=int(input("Please enter a number between 0 and 100: "))
    if '7' in str(num):
        return 'Penny'
    elif num % 7 == 0:
        return 'Howard'
    elif num % 3 == 0 and num % 5 == 0:
        return 'Raj'
    elif num % 5 == 0:
        return 'Leonard'
    elif num % 3 == 0:
        return 'Sheldon'
    else:
        return f'Your number, {num}, did not match and of the criteria!'
print(big_bang_number())