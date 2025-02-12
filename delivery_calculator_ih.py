#This program will determine the cost of a delivery based on the given order cost and miles away
def delivery_cost():
    order_total = int(input('Please enter the amount of the order: '))
    if order_total <= 50:
        order_total *=1.1
    else:
        order_total *=1.05
    miles_tax = int(input('Please enter the miles: '))/10
    final_total = order_total+miles_tax
    print(f'Total to be collected: {round(final_total,2)}')
delivery_cost()
    