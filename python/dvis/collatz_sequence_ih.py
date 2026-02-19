#This program will return the collatz sequence for a given positive integer

def collatz():
    num = int(input("Please enter a positive integer without decimals: "))
    collatz_sequence = [num]
    while collatz_sequence[-1] != 1:
        last_num = collatz_sequence[-1]
        if last_num %2 == 0:
            collatz_sequence.append(int(last_num/2))
        else:
            collatz_sequence.append(last_num*3+1)
    return collatz_sequence
print(collatz())