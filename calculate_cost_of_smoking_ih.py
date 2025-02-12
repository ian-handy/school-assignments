#This program will calculate the cost of smoking based on the given cost of cigarettes, packs per day, years smoked, and percent increase in cigarette cost

def smoking_cost():
    cig_price = float(input('Please enter the current cost of a pack of cigarettes: '))
    packs_per_year = int(input('Please enter the number of packs smoked per day: '))*365
    smoking_years = int(input('Please enter the number of smoking years: '))
    percent_increase = float(input('Please enter the average percent increase in the cost of a pack of cigarette each year (as a decimal): '))+1
    total_cost = cig_price*packs_per_year
    for _ in range(smoking_years-1):
        cig_price *= percent_increase
        total_cost+=cig_price*packs_per_year
    print(f'Total Cost of Smoking: {total_cost}')
    return total_cost
smoking_cost()