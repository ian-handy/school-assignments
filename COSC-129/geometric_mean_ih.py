#This program will calculate the geometric mean and end value of a property based on the purchase price, years held, and percent fluxuation for each year

from functools import reduce

def geometric_mean():
    original_price = int(input("Please enter the original purchase price of the property: "))
    years_held = int(input("Please enter the number of years that the property will be held: "))
    interest_change = []
    for year in range(years_held):   
        interest_change.append(1.0 + float(input(f'Please enter the percent change in value for year {year+1} as a number, negative numbers indicate decrease in value: '))/100)
    return (f'After {years_held} years, your property would be valued at {round(original_price * reduce(lambda a,b: a*b,interest_change),2)}.'
        + f'The geometric mean of the interest change is {round((reduce(lambda a,b: a*b,interest_change)**(1/years_held)),2)}')
print(geometric_mean())