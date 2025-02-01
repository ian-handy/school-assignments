#Virus Assignment

def virus():
    print("This program will calculate the number of people that are infected by a hypothetical virus between 1-6 months from the start date.")
    population = int(input("Please enter the population: "))
    total_months = int(input("Please enter a number of months:"))
    uninfected = population
    infected = 0
    infected_total = 0
    infection_rate = 0.05
    for month in range(total_months):
        infected = int(uninfected * infection_rate)
        infected_total += infected
        uninfected -= int(infected)
        infection_rate += 0.05
        print(f'Infected in month {month + 1}: {infected}')
    print(f'Total Infected: {infected_total}\nTotal Uninfected: {uninfected}')
virus()