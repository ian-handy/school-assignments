#This program will simulate the value of a stock over the course of 40 years, where the max fluxuation in the value of the stock is capped at 5%

import random

def investment():
    print(f'Year #\t% Change\tCurrent Value\n')
    current_value = 10000
    for year in range(40):
        percent_change = random.random() / 10 - 0.05
        current_value *= 1+percent_change
        print(f'{year+1}\t{round(percent_change*100,2)}%\t{round(current_value,2)}\n')
print(investment())