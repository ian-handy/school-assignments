#This program will calculate the standard deviation of a population of 20 numbers randomly generated between 1-50

import random
population = [random.randrange(1, 51) for i in range(20)]

mean = sum(population) / len(population)
variance = 0

for num in population:
    variance += (num - mean)**2

variance /= len(population)

st_dev = variance**(1/2)

print(f'Population: {population}\nMean: {mean}\nVariance: {variance}\nStandard Deviation: {st_dev}')