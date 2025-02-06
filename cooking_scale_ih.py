#This program will calculate the scaled ingredients of a recipe given how much of an individual ingredient you have

def cooking_scale():
    required_amount = float(input("Please enter the amount of the limiting ingredient that the recipe calls for: "))
    have_amount = float(input("Please enter how much of this ingredient you have:"))
    scale = have_amount / required_amount
    other_ingredients = int(input("How many other ingredients do you need to be scaled? "))
    for i in range(other_ingredients):
        required_amount = float(input(f'Enter the amount of other ingredient {i+1} called for: '))
        print(round(required_amount * scale, 2))
cooking_scale()