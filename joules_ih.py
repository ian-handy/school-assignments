#Joules Assignment

def joules_required():
    print("This program will calculate the amount of energy that will be required to take a quantity of water (in kg) from an initial temperature (in Celcius) to a final temperature (in Celcius).")
    water_weight = float(input("Please enter the amount of water in kilograms: "))
    initial_temp = float(input("Please enter the initial temperature: "))
    final_temp = float(input("Please enter the final temperature: "))
    print(f'The energy needed is: {water_weight * (final_temp - initial_temp) * 4184.0} joules')
joules_required()