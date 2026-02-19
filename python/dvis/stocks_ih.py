#This program will calculate your net profit on the stocks you sell after taxes

stocks =[
 [15000, 11500, 'S'],
 [15000, 25100, 'L'],
 [30000, 21000, 'L'],
 [15000, 50000, 'S'],
 [5000, 21000, 'S'],
 [25000, 40000, 'L'],
 [10000, 10500, 'S'],
 [20000, 11000, 'S'],
 [30000, 11500, 'S'],
 [30000, 11500, 'L'],
 [15000, 45000, 'L'],
 [15000, 25100, 'S'],
 [35000, 50000, 'S'],
 [25000, 30000, 'L'],
 [30000, 45000, 'S']
 ]

short_stocks = []

long_stocks = []

for stock in stocks:
    if stock[2] =='S':
        short_stocks.append(stock[1]-stock[0])
    else:
        long_stocks.append(stock[1]-stock[0])

print("Long term gains: ${:,.2f}".format(sum(long_stocks)))
print("Short term gains: ${:,.2f}".format(sum(short_stocks)))

short_tax = 0
long_tax = 0

for stock in short_stocks:
    if stock > 0:
        short_tax += stock*.22

for stock in long_stocks:
    if stock > 0:
        long_tax += stock*.15

print("Long term gain tax: ${:,.2f}".format(long_tax))
print("Short term gain tax: ${:,.2f}".format(short_tax))

print("Net profit: ${:,.2f}".format(sum(long_stocks)+sum(short_stocks)-long_tax-short_tax))
