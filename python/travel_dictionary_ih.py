locations = {'A': 1,  'B': 23, 'C': 56, 'D': 89, 'E': 101, 'F': 123, 'G': 156, 'H': 203, 'I': 225, 'J': 277, 'K': 315, 'L': 351, 'M': 388, 'N': 400, 'O': 427, 'P': 470, 'Q': 499, 'R': 529, 'S': 555, 'T': 579, 'U': 598, 'V': 604, 'W': 620, 'X': 649, 'Y': 677, 'Z': 700}

gallons_left = float(input("How many gallons do you have in your tank?: "))
while gallons_left <= 0:
    gallons_left = float(input("Please enter a positive, non-zero number. How many gallons do you have in your tank?: "))
mpg = float(input("What is your car's MPG?: "))
while mpg <=0:
    mpg = float(input("Please enter a positive, non-zero number. What is your car's MPG?: "))

travel_miles = gallons_left * mpg

available_locations = {key:value for key,value in locations.items() if value <= travel_miles}

for key,value in available_locations.items():
    print(f'You can visit {key} which is {value} mile(s) away.')